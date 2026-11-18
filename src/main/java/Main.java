package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java main.java.Main <n> <s>");
            System.exit(1);
        }

        int n;
        int s;

        try {
            n = Integer.parseInt(args[0]);
            s = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers.");
            return;
        }

        if (n <= 0 || s <= 0) {
            System.out.println("Both arguments must be positive.");
            return;
        }

        try {
            BucketManager manager = new BucketManager(n, s);
            manager.initializeBuckets();

            System.out.println("Buckets created: " + n);
            System.out.println("Bucket capacity: " + s);

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                System.out.println("Received: " + input);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
