package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two Strings, decide if one is a permutation of the other.
 *
 */

public class CheckPermutation {
  
  /**
   * Attempt 1
   * Sort both string and check if equal.
   * O(nlogn)
   * @param a String
   * @param b String
   * @return
   */
  public boolean checkPermutation(String a, String b) {
  
    if (a == null || b == null || a.length() != b.length()) {
      return false;
    }
  
    char[] charArrA = a.toCharArray();
    char[] charArrB = b.toCharArray();
    
    Arrays.sort(charArrA); 
    Arrays.sort(charArrB); //taken O(nlogn) time
    
    String sortedA = String.valueOf(charArrA);
    String sortedB = String.valueOf(charArrB);
    
    if (sortedA.equalsIgnoreCase(sortedB)) {
      return true;
    }
    
    return false;
  }
  
  /**
   * Attempt 2
   * Searching is bottleneck in earlier attempt.
   * Use map to check if all characters are same.
   * O(n)
   * @param a String
   * @param b String
   * @return
   */
  public boolean checkPermutation1(String a, String b) {
    
    if (a == null || b == null || a.length() != b.length()) {
      return false;
    }
    
    char[] charArrA = a.toCharArray();
    char[] charArrB = b.toCharArray();
    
    Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
    
    for (char c: charArrA) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }
    
    for (char c: charArrB) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
      if (charCounts.get(c) < 0) {
        return false;
      }
    }
    
    return true;
  }
  
  /**
   *  Main method.
   * @param args parameters
   */
  public static void main(String[] args) {
    CheckPermutation checkPermutation = new CheckPermutation();
    System.out.println(checkPermutation.checkPermutation1("acb", "bad"));
    System.out.println(checkPermutation.checkPermutation1("acbd", "bad"));
    System.out.println(checkPermutation.checkPermutation1("acbdefg", "cbeafdg"));
    System.out.println(checkPermutation.checkPermutation1("acb123", "321bad"));
    System.out.println(checkPermutation.checkPermutation1("a123cb", "bac321"));
    System.out.println(checkPermutation.checkPermutation1("My name is", "amen mysi "));
    System.out.println(checkPermutation.checkPermutation1("my name is", "amen mysi "));
    System.out.println(checkPermutation.checkPermutation1("zxcv", "vcxz"));
  }

}
