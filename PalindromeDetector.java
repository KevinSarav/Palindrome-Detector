// Program Name: Palindrome Detector
// Programmer: Kevin Saravia, 1478627
// Assignment Number: Project #2
// Purpose: <A short problem description>
import java.util.Scanner;
import java.io.*;

public class PalindromeDetector{
  public static void main(String[] args) {
    PalindromeDetector methods = new PalindromeDetector();
    Scanner fyle = null;

    try{
      fyle = new Scanner(new FileInputStream("palindromes.txt"));
    }
    catch(FileNotFoundException f){
      System.out.println("File not found.");
      System.exit(0);
    }

    while(fyle.hasNextLine()){
      String line = fyle.nextLine();
      String lettersOnly = methods.letterChecker(line);
      int size = lettersOnly.length();
      Stack lStack = new Stack(size);
      lStack = methods.makeLetterStack(lettersOnly, size);
      Stack rStack = new Stack(size);
      rStack = methods.makeReverStack(lettersOnly, size);
      methods.printIfPali(lStack, rStack, size, line);
    }
  }

  public String letterChecker(String l){
    String lOnly = "";

    for(int i = 0; i < l.length(); i++){
      char c = l.charAt(i);

      if(c > 96 && c  < 123)
        lOnly += Character.toString(c);
      else if(c > 64 && c < 91){
        c += 32;
        lOnly += Character.toString(c);
      }
    }

    return lOnly;
  }

  public Stack makeLetterStack(String l, int s){
    Stack stak = new Stack(s);

    for(int i = 0; i < s; i++){
      char c = l.charAt(i);
      stak.push(Character.toString(c));
    }

    return stak;
  }

  public Stack makeReverStack(String l, int s){
    Stack revSt = new Stack(s);

    for(int i = 0; i < s; i++){
      char c = l.charAt(s - i - 1);
      revSt.push(Character.toString(c));
    }

    return revSt;
  }

  public void printIfPali(Stack f, Stack r, int s, String l){
    boolean isPali = true;

    while(!(f.isEmpty())){
      if(!(f.pop().equals(r.pop()))){
        isPali = false;
        break;
      }
    }

    if(isPali == true)
      System.out.println("\"" + l + "\"" + " is a palindrome.");
  }
}