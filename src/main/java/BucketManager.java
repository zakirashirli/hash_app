package main.java;

import java.io.File;
import java.io.IOException;

public class BucketManager {

    private final int n;
    private final int s;

    public BucketManager(int n, int s) {
        this.n = n;
        this.s = s;
    }

    public void initializeBuckets() throws IOException {

        for (int i = 1; i <= n; i++) {
            File file = new File(i + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
        }
    }

    public int getBucketCapacity() {
        return s;
    }
}
