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

<b>Completed:</b> Initial README documentation and project requirements.

<b>Selected:</b> Java 21 as the programming language and MurmurHash3 as the hashing algorithm.

<b>In progress:</b> Project setup in IntelliJ IDEA.

<b>Not started:</b> Java implementation, bucket file storage, and overflow handling.