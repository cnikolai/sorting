package edu.cnm.deepdive;

import java.util.Random;
import java.util.stream.IntStream;

public class SearchTest {

  public static void main(String[] args) {
    Random rng = new Random();
    int[] haystack = IntStream
        .generate(rng::nextInt)
        .limit(1_000_000)
        .toArray();
    int[] needles = IntStream
        .generate(rng::nextInt)
        .limit(10_000)
        .toArray();
    long start = System.currentTimeMillis();
    //how many needles are in haystack.
    int count = (int) IntStream
        .of(needles)
        .map((needle) -> LinearSearch.search(needle, haystack))
        .filter((position) -> position >=0 )//if item is true, keep on stream, otherwise, take off stream
        .count();
    long finish = System.currentTimeMillis();
    System.out.printf("Linear Search: count = %d, time = %dms%n", count, finish-start);

    start = System.currentTimeMillis();
    QuickSort.sort(haystack);
    finish = System.currentTimeMillis();
    System.out.printf("QuickSort: time = %dms%n", finish-start);

    start = System.currentTimeMillis();
    count = (int) IntStream
        .of(needles)
        .map((needle) -> BinarySearch.search(haystack, needle))
        .filter((position) -> position >=0 )//if item is true, keep on stream, otherwise, take off stream
        .count();
    finish = System.currentTimeMillis();
    System.out.printf("BinarySearch: count = %d, time = %dms%n", count, finish-start);
  }

}
