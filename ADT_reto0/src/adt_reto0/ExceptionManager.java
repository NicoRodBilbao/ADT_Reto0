package adt_reto0;

public class ExceptionManager {

    public ExceptionManager() {
    }

    public void throwException(Exception e) {
        System.out.println("RUNTIME ERROR... printing stacktrace:");
        e.printStackTrace();
    }
     
}
