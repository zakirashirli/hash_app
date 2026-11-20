package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("hash_app ");

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0 || s <= 0) {
            System.out.println("Both arguments must be positive.");
            return;
        }

        try {
            BucketManager manager = new BucketManager(n, s);
            manager.initializeBuckets();

            while (true) {
                System.out.print("Please enter the string: ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    continue;
                }

                int bucket = manager.store(input);

                System.out.println(
                        input + " added to " + bucket + ".txt"
                );
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}