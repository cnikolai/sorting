package edu.cnm.deepdive;

public class LinearSearch {

  public static int search(int needle, int[] haystack) {
    int position = -1;
    for (int i = 0; i < haystack.length; i++) {
      if (needle == haystack[i]) {
        position = i;
        break;
      }
    }
    return position;
  }

}
