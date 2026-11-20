# hash_app

## Project Overview
The purpose of hash_app is to demonstrate how a file-based hashing system stores strings efficiently by distributing them across multiple buckets. 
Instead of storing every string in one large file, hash_app uses a hash function to determine which bucket file should contain each string.

## Technologies

| Technology | Purpose |
|---|---|
| Java 21 | Main programming language |
| Java Standard Library | Console input, file handling, and application logic |
| IntelliJ IDEA | Integrated Development Environment (IDE) |
| Git | Version control |
| GitHub | Repository hosting and submission |
| MurmurHash3 | Fast, non-cryptographic hashing of input strings |

## Project Requirements

1. <i>Command Line Parameters</i>
   n = number of hash buckets
   s = bucket size in characters

2. <i>String Input</i>
   Accept Strings while the program runs.

3. <i>Hashing</i>
   Use a Fast Hashing algorithm to calculate a hash value.

4. <i>Bucket Selection</i>
   Assign each string to one of n bucket files.

5. <i>File Naming</i>
   Use filenames from "1.txt" through "n.txt".

6. <i>Collisions</i>
   Allow multiple Strings in the same bucket.

7. <i>Bucket Capacity</i>
   Track the number of characters stored in each bucket.

8. <i>Overflow Handling</i>
   Create overflow files when the bucket size limit is exceeded.

9. <i>Overflow References</i>
   Maintain references between the original bucket and
   its overflow files, including the last overflow file.

10. <i>Storage Format</i>
    Store strings without commas or other separators.

## Development Status

<b>Completed:</b> README documentation, Java project setup, input validation, continuous input handling, bucket initialization, MurmurHash3 integration, bucket file storage, and overflow handling.

<b>Hashing Algorithm:</b> MurmurHash3, implemented in Java without external libraries.

<b>Status:</b> Implementation completed.

## Hashing Algorithm

1. <i>Algorithm</i>
   MurmurHash3 is used to calculate hash values for input strings.

2. <i>Bucket Selection</i>
   The calculated hash value determines the bucket file using:

3. <i>Dependencies</i>
   No external libraries or dependencies are required.

## How to Run

1. <i>Requirements</i>
   Java 21 or newer.

2. <i>Setup</i>
   Clone the repository and open the project in IntelliJ IDEA.

3. <i>Execution</i>
   Run `Main.java` and enter two positive integers:
   - `n` = number of buckets
   - `s` = maximum characters per bucket file

4. <i>String Input</i>
   Enter strings when prompted. The application automatically calculates the hash and stores each string in the corresponding bucket.

5. <i>Example Output</i>

   ```text
   hash_app 5 20
   Please enter the string: Hello
   Hello added to 3.txt
   Please enter the string: World
   World added to 1.txt
   Please enter the string: Test
   Test added to 3.txt
   Please enter the string:
   ```

   Bucket numbers are determined by the hash algorithm.

## Overflow Handling

1. <i>Bucket Capacity</i>
   Each bucket file stores a maximum of `s` Java characters.

2. <i>Overflow Files</i>
   When a bucket reaches its capacity, additional files are created, such as `1_overflow_1.txt`.

3. <i>Overflow References</i>
   A `.ref` file stores the number of the latest overflow file for each bucket.

4. <i>Data Persistence</i>
   Existing file contents are preserved between application runs.