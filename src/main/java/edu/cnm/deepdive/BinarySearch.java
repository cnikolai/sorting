package edu.cnm.deepdive;

public class BinarySearch {

  public static int search(int[] haystack, int needle) {
    return search(haystack, needle, 0, haystack.length);
  }

  public static int search(int[] haystack, int needle, int start, int end) {
    //assumption: in sorted order
    int position;
    if (end > start) {
      int midpoint = (start + end) / 2; //throw away the fractional part
      int midpointValue = haystack[midpoint];
      if (midpointValue < needle) {
        position = search(haystack, needle, midpoint + 1, end);
      } else if (midpointValue > needle) {
        position = search(haystack, needle, start, midpoint);
      } else {
        position = midpoint;
      }
    } else {
      //position = -(start + 1);
      position = ~start;
    }
    return position;
  }

}
