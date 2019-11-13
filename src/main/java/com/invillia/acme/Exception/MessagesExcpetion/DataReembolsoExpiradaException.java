package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class DataReembolsoExpiradaException extends AppMeRunTimeException {
    public DataReembolsoExpiradaException(){
        super("A data para reembolso passou de 10 dias");
    }
}
