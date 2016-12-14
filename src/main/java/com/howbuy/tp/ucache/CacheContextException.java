package com.howbuy.tp.ucache;

public class CacheContextException extends Exception {

    private static final long serialVersionUID = 1744585138919636984L;

    public CacheContextException(String message) {
        super(message);
    }
    
    public CacheContextException(Throwable cause) {
        super(cause);
    }
    
    public CacheContextException(String message, Throwable cause) {
        super(message, cause);
    }
}
