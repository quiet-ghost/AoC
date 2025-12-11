package dev.quietghost;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {
  static boolean isValidId(long number) {
    String numStr = String.valueOf(number);
    int len = numStr.length();
    if (len % 2 != 0) {
      return false;
    }
    int mid = len / 2;
    String firstHalf = numStr.substring(0, mid);
    String secondHalf = numStr.substring(mid, len);
    if (firstHalf.equals(secondHalf)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    String line;
    long sum = 0;

    BufferedReader file = new BufferedReader(new FileReader("src/main/java/dev/quietghost/Files/sample.txt"));
    while ((line = file.readLine()) != null) {
      String[] ranges = line.split(",");
      for (String range : ranges) {
        String[] parts = range.split("-");
        long firstRange = Long.parseLong(parts[0]);
        long secondRange = Long.parseLong(parts[1]);
        for (long i = firstRange; i <= secondRange; i++) {
          if (isValidId(i) == true) {
            sum += i;
          }
        }
        System.out.println(range);
        System.out.println("Sum -> " + sum);
      }
    }
    file.close();
  }
}
