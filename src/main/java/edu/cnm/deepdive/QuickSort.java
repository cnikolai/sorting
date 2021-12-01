package edu.cnm.deepdive;

public class QuickSort {

  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int start, int end) {
    if (end > start + 1) {
      //pick a pivot value
      //Divide
      //Naive approach: Pick start element as pivot value
      //More advanced: take some number of random numbers, take median of that value and use that
      int pivotValue = data[start];
      int dividerIndex = start;
      for (int currentIndex = start + 1; currentIndex < end; currentIndex++) {
        int currentValue = data[currentIndex];
        if (currentValue <= pivotValue) {
          //dividerIndex++;
          if (++dividerIndex < currentIndex) {//increment divider index before use the value.
            data[currentIndex] = data[dividerIndex];
            data[dividerIndex] = currentValue;
          }
        }
      }
      data[start] = data[dividerIndex];
      data[dividerIndex] = pivotValue;
      sort(data, start, dividerIndex);
      sort(data, dividerIndex + 1, end);
      //Conquer: Do nothing!
    }
  }

}
