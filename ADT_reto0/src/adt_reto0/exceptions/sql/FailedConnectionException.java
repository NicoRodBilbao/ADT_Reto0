package adt_reto0.exceptions.sql;

public class FailedConnectionException
extends Exception {
    
    public FailedConnectionException(String errorMsg) {
        super(errorMsg);
    }

}
