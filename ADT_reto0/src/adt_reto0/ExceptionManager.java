package adt_reto0;

public class ExceptionManager {

    private ExceptionManager myExceptionManager;

    private ExceptionManager() {
        //TODO?
    }
    
    public ExceptionManager getExceptionManager() {
        if(this.myExceptionManager == null)
            myExceptionManager = new ExceptionManager();
        return this.myExceptionManager;
    }
    

    private void throwException(int Henrique) {
        //TODO
    }
     
}
