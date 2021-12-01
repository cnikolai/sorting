package edu.cnm.deepdive;

public class MergeSort {

  //order(nlogn)

  //will sort array in place.
   public static void sort(int[] data) {
      sort(data, 0, data.length);
   }

   public static void sort(int[] data, int start, int end) {
      if (end > start + 1) {
        // Divide
        int midpoint = (start + end)/2;
        sort(data, start, midpoint); //sort the left side
        sort(data, midpoint, end); //sort the right side
        // Conquer (merge)
        int[] merged = new int[end - start];
        int leftIndex = start;
        int rightIndex = midpoint;
        int mergedIndex = 0;
        while (leftIndex < midpoint && rightIndex < end) {
          int leftValue = data[leftIndex];
          int rightValue = data[rightIndex];
          if (leftValue <= rightValue) {
            merged[mergedIndex] = leftValue;
            leftIndex++;
            //merged[mergedIndex] = rightValue;
          }
          else {
            merged[mergedIndex] = rightValue;
              rightIndex++;
              //merged[mergedIndex++] = leftValue;
          }
          mergedIndex++;
        }
        if (leftIndex < midpoint) {// right side is exhausted
          System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint-leftIndex);
        }
        else {// left side is exhausted
          System.arraycopy(data, rightIndex, merged, mergedIndex, end - rightIndex);
        }
        System.arraycopy(merged, 0, data, start, merged.length);
        //only touching their piece of the array.
      }
   }
}
