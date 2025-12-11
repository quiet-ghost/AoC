package dev.quietghost;

import java.io.BufferedReader;
import java.io.FileReader;

public class part1 {
  public static void main(String[] args) throws Exception {
    String line;
    int sum = 0;

    BufferedReader file = new BufferedReader(new FileReader("src/main/java/dev/quietghost/files/input.txt"));
    while ((line = file.readLine()) != null) {
      System.out.println("String bank -> " + line);
      int[] digits = line.chars().map(Character::getNumericValue).toArray();
      System.out.println("Digit Bank -> " + java.util.Arrays.toString(digits));

      int firstValue = 0;
      int firstIndex = 0;
      int secondValue = 0;

      for (int i = 0; i < digits.length - 1; i++) {
        if (digits[i] > firstValue) {
          firstValue = digits[i];
          firstIndex = i;
        }
      }
      for (int i = firstIndex + 1; i < digits.length; i++) {
        if (digits[i] > secondValue) {
          secondValue = digits[i];
        }
      }
      int joltage = firstValue * 10 + secondValue;
      sum += joltage;
      System.out.println("joltage -> " + joltage);
      System.out.println(firstValue + " " + secondValue);
    }
    System.out.println("total -> " + sum);
    file.close();
  }
}
