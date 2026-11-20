package main.java;

import java.nio.charset.StandardCharsets;

public class MurmurHash3 {

    public static int hash(String input) {

        byte[] data = input.getBytes(StandardCharsets.UTF_8);

        int hash = 0;
        int length = data.length;
        int i = 0;

        while (i + 4 <= length) {

            int k = (data[i] & 0xff)
                    | ((data[i + 1] & 0xff) << 8)
                    | ((data[i + 2] & 0xff) << 16)
                    | ((data[i + 3] & 0xff) << 24);

            k *= 0xcc9e2d51;
            k = Integer.rotateLeft(k, 15);
            k *= 0x1b873593;

            hash ^= k;
            hash = Integer.rotateLeft(hash, 13);
            hash = hash * 5 + 0xe6546b64;

            i += 4;
        }

        int k = 0;
        int remaining = length - i;

        if (remaining >= 3) {
            k ^= (data[i + 2] & 0xff) << 16;
        }

        if (remaining >= 2) {
            k ^= (data[i + 1] & 0xff) << 8;
        }

        if (remaining >= 1) {
            k ^= data[i] & 0xff;
            k *= 0xcc9e2d51;
            k = Integer.rotateLeft(k, 15);
            k *= 0x1b873593;
            hash ^= k;
        }

        hash ^= length;
        hash ^= hash >>> 16;
        hash *= 0x85ebca6b;
        hash ^= hash >>> 13;
        hash *= 0xc2b2ae35;
        hash ^= hash >>> 16;

        return hash;
    }
}
