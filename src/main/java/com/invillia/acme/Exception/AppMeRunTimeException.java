package com.invillia.acme.Exception;

public class AppMeRunTimeException extends RuntimeException{

        private String msg;

    public AppMeRunTimeException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMessage(){
            return msg;
        }

}
