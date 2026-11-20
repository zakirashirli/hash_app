package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BucketManager {

    private final int n;
    private final int s;

    public BucketManager(int n, int s) {
        this.n = n;
        this.s = s;
    }

    public void initializeBuckets() throws IOException {
        for (int i = 1; i <= n; i++) {
            Path file = Path.of(i + ".txt");

            if (Files.notExists(file)) {
                Files.createFile(file);
            }
        }
    }

    public int store(String input) throws IOException {
        int hash = MurmurHash3.hash(input);
        int bucket = Math.floorMod(hash, n) + 1;

        Path reference = Path.of(bucket + ".ref");
        int overflow = 0;

        if (Files.exists(reference)) {
            overflow = Integer.parseInt(
                    Files.readString(reference).trim()
            );
        }

        int position = 0;

        while (position < input.length()) {

            Path file;

            if (overflow == 0) {
                file = Path.of(bucket + ".txt");
            } else {
                file = Path.of(
                        bucket + "_overflow_" + overflow + ".txt"
                );
            }

            if (Files.notExists(file)) {
                Files.createFile(file);
            }

            int currentLength = Files.readString(file).length();
            int available = s - currentLength;

            if (available <= 0) {
                overflow++;

                Files.writeString(
                        reference,
                        String.valueOf(overflow)
                );

                continue;
            }

            int end = Math.min(
                    position + available,
                    input.length()
            );

            Files.writeString(
                    file,
                    input.substring(position, end),
                    StandardOpenOption.APPEND
            );

            position = end;
        }

        return bucket;
    }
}
