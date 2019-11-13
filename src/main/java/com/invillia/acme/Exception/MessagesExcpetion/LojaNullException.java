package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class LojaNullException extends AppMeRunTimeException {
    public LojaNullException(){
        super("A Loja não existe");
    }
}
