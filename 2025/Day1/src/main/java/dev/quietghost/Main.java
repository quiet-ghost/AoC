package dev.quietghost;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  static int crossing(int start, char direction, int moves) {
    if (moves == 0)
      return 0;
    int count = 0;

    count += moves / 100;
    int remainder = moves % 100;
    if (remainder > 0) {
      if (direction == 'R') {
        if (start + remainder >= 100) {
          count++;
        }
      } else {
        if (remainder >= start && start > 0) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader file = new BufferedReader(new FileReader("src/main/java/dev/quietghost/files/input.txt"));

    String line;
    int position = 50;
    int zeroCount = 0;

    System.out.println("================");
    while ((line = file.readLine()) != null) {
      char direction = line.charAt(0);
      int value = Integer.parseInt(line.substring(1));

      int crossings = crossing(position, direction, value);
      zeroCount += crossings;

      if (direction == 'L') {
        position = ((position - value) % 100 + 100) % 100;
        if (position == 0) {
        }
      } else if (direction == 'R') {
        position = (position + value) % 100;
        if (position == 0) {
        }
      }
      System.out.println(line + "-> position: " + position + "\n" + "total crossings: " + crossings);
    }
    System.out.println("Total number of 0's: " + zeroCount);
    System.out.println("================");
    file.close();
  }

}
