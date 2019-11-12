package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class EmailExistenteException extends AppMeRunTimeException {
    public EmailExistenteException(){
        super("Este Email já está cadastrado");
    }
}
