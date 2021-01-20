package main.java;

/**
 * Replace all spaces in a string with '%20' given true length of the string
 *
 */
public class Urlify {

  /**
   *  Attempt1
   *  go through the char array find no of spaces iterate from end to swap characters.
   *  O(n)       
   * @param str String
   * @param len int
   * @return
   */
  public String urlify(String str, int len) {
    char[] charArr = str.toCharArray();
    int spaceCount = 0;
    char[] repChar = "02%".toCharArray();
    
    for (int i = 0; i < len; i++) {
      if (charArr[i] == ' ') {
        spaceCount++;
      }
    }
    for (int i = len - 1, j = charArr.length - 1; i >= 0 && j >= 0; i--, j--) {
      if (spaceCount > 0) {
        if (charArr[i] != ' ') {
          charArr[j] = charArr[i];
        } else {
          fill(charArr, j, repChar);
          spaceCount--;
          j = j - 2;
        }
      }
    }
    
    return String.valueOf(charArr);
  }
  
  private void fill(char[] charArr, int j, char[] repChar) {
    for (int k = 0; k < repChar.length; k++, j--) {
      charArr[j] = repChar[k];
    }
  }
  
  public static void main(String[] args) {
    Urlify urlify = new Urlify();
    System.out.println(urlify.urlify("Mr John Smith    ", 13));
    System.out.println(urlify.urlify("Hi, I am John wayne.        ", 20));
    System.out.println(urlify.urlify("Hi, ", 3));
    System.out.println(urlify.urlify("Hi, .  ", 5));
    System.out.println(urlify.urlify(" ", 0));
  }
}
