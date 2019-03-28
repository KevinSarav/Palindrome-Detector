import java.util.Scanner;
import java.io.*;

public class Stack{
  private int maxSize, top;
  private String[] lineStack;

  public Stack(int s){
    maxSize = s;
    lineStack = new String[maxSize];
    top = -1;
  }

  public void push(String w){
    lineStack[++top] = w;
  }

  public String pop(){
    return lineStack[top--];
  }

  public String peek(){
    return lineStack[top];
  }

  public boolean isEmpty(){
    return (top == -1);
  }

  public boolean isFull(){
    return (top == maxSize - 1);
  }

  public int getSize(){
    return top;
  }
}