# Python-v.-Java---Resolving-the-Same-Task-with-Two-Different-Languages

## Overview
This repository compares solutions for the same problem using two programming languages: Java and Python. The goal is to create a method that compresses a string by reducing sequences of repeating characters into the character followed by the number of times it repeats consecutively. Additionally, to create a decompressing method that reconstructs the original string.

The task was actually thought to be resolved using Java, but I thought it would be interesting to resolve the task using Python also, since for me it's easier to approach the task with Python first, since it's a bit more flexible and easy to write, and then translate those same ideas into Java.

## Task Description

### Problem
You are given a string consisting of lowercase letters. The task is to:
1. **Compress the string** by reducing sequences of repeating characters into the character followed by the number of times it repeats consecutively.
2. Optionally, **decompress** the string to reconstruct the original string.

### Input and Output
- **Input**: A string containing only lowercase letters. The input string can also be empty.
- **Output**: A compressed or decompressed string as described.

### Example
For the compression task:
- `"aaabb"` → `"a3b2"`
- `"abc"` → `"a1b1c1"`
- `""` → `""`

For the decompression task:
- `"a3b2"` → `"aaabb"`
- `"a1b1c1"` → `"abc"`
- `""` → `""`

## Code

### Java Code
```` java
public class Main {
    public static void main(String[] args) {
        String example1 = "aaabbbcccdeefgg";
        String example2 = "a3b3c3d1e2f1g2";
        String example3 = "";
        System.out.println("Compress aaabbbcccdeefgg: " + compressString(example1));
        System.out.println("Compress empty string: " + compressString(example3));
        System.out.println("Decompress a3b3c3d1e2f1g2: " + decompressString(example2));
        System.out.println("Decompress empty string: " + decompressString(example3));
    }

    static String compressString(String word) {
        String compressed = "";
        int num = 1;

        if (!word.isEmpty()) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.charAt(i) == word.charAt(i + 1)) {
                    num += 1;
                } else {
                    compressed += word.charAt(i) + Integer.toString(num);
                    num = 1;
                }
            }
            compressed += word.charAt(word.length() - 1) + Integer.toString(num);  
        }

        return compressed;
    }

    static String decompressString(String word) {
        String decompressed = "";

        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i += 2) {
                char c = word.charAt(i);
                int repeatCount = word.charAt(i + 1) - '0'; 
                decompressed += String.valueOf(c).repeat(repeatCount);
            }
        }

        return decompressed;    
    }
}
````

### Python Code
```` python
def compress_string(word):
  compressed = ""
  num = 1
  
  if word:
    for i in range(0, len(word) - 1):
      if word[i] == word[i+1]:
        num += 1
      else:
        compressed += word[i] + str(num)
        num = 1
    
    compressed += word[-1] + str(num)
  
  return compressed

def decompress_string(word):
  decompressed = ""
  
  if word:
    for i in range(0, len(word), 2):
      decompressed += str(word[i] * int(word[i+1]))

  return decompressed

# Printing everything:
trial = "aaabbbcccdeefgg"
trial1 = ""
print(f"Compress aaabbbcccdeefgg: {compress_string(trial)}")
print(f"Compress empty string: {compress_string(trial1)}")
trial_d = "a3b3c3d1e2f1g2"
trial_d1 = ""
print(f"Decompress a3b3c3d1e2f1g2: {decompress_string(trial_d)}")
print(f"Decompress empty string: {decompress_string(trial_d1)}")
````

## Explanation of Solution

### Compression Method
1) The main idea is to iterate through the string and compare each character with the next one. If the characters are the same, the count is increased (num).
2) When the characters are different, the current character and its count (num) are appeneded to the compressed string and reset the count (num) to 1.
3) Edge cases of empty strings are handled at the start by checking if the input is empty and returning an empty string immediately, and and empty string is returned.

### Decompression Method
1) This method iterates over the input string, where every two characters represent a character and its corresponding repetition count.
2) For each pair of characters, the character is multiplied by the repetition count and appended to the result string.
3) Similar to the compression method, the edge case of an empty string is checked at the start, and and empty string is returned.

### Conclusion

Both Java and Python do a great job at solving the task of compressing and decompressing strings, but each language has its own strengths.

#### Core Logic
The task itself — finding repeated characters and turning them into a compressed version — is pretty much the same in both languages. The main difference is how they do it: Java is more detailed and clear, while Python is more concise and quick to write.

#### Java: Clear and Reliable
In Java, you have to write a bit more code, but this actually makes things a bit clearer. You need to be more specific, like checking if the string is empty with `if (!word.isEmpty())`, which helps avoid problems later. It seems to me that Java comes in very handy when you want to make your code clear as water.

#### Python: Quick and Easy
Python is super simple and fast to write. The way it handles things, like checking if the string is empty with `if word:`, makes the code short and easy to follow. In my opinion Python is a bit easier to write, and it might come very handy when you want to write something very fast and in a flexible manner.

#### Final Thoughts
Both languages get the job done, but they do it in different ways. Java is more structured and very clear. Python, on the other hand, is quick to write and easy to understand. Either way, the task shows can be resolved with both languages. 
Maybe one "strategic" move might be to write first the code with python, just to get the idea down, and then translate it to Java.. Or maybe that's just me!
