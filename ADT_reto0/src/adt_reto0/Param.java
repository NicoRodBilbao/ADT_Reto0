package adt_reto0;

import java.util.Scanner;

public class Param<T> {

  private Scanner console = new Scanner(System.in);
  private String message = "Enter ";
  private Class<T> c;
  
  public Param(Class<T> c, String param) {
    this.c = c;
    this.message += param;
    this.message += ": ";
  }

  public T getParams() {
    boolean done = false;
    while(!done) {
      try {
        System.out.println(message);
        T input = this.c.cast(console.next());
        done = true;
        return input;
      } catch (Exception e) {
        //ExceptionManager();
      }
    }
    return null;
  }

}
