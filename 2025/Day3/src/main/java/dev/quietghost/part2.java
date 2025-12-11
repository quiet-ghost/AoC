package dev.quietghost;

import java.io.BufferedReader;
import java.io.FileReader;

public class part2 {
  public static void main(String[] args) throws Exception {
    String line;
    long sum = 0;

    BufferedReader file = new BufferedReader(new FileReader("src/main/java/dev/quietghost/files/input.txt"));
    while ((line = file.readLine()) != null) {
      int[] digits = line.chars().map(Character::getNumericValue).toArray();
      System.out.println("Digit Bank -> " + java.util.Arrays.toString(digits));

      StringBuilder result = new StringBuilder();
      int currentStart = 0;
      int digitsRemaining = 12;
      for (int position = 0; position < 12; position++) {
        int searchEnd = digits.length - digitsRemaining;

        int maxDigit = -1;
        int maxIndex = -1;
        for (int i = currentStart; i <= searchEnd; i++) {
          if (digits[i] > maxDigit) {
            maxDigit = digits[i];
            maxIndex = i;
          }
        }
        result.append(maxDigit);
        currentStart = maxIndex + 1;
        digitsRemaining--;
      }
      sum += Long.parseLong(result.toString());
      System.out.println("Joltage -> " + result);
    }
    System.out.println("Sum -> " + sum);
    file.close();
  }
}
