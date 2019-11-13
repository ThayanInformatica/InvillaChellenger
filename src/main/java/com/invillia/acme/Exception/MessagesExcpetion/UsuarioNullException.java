package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class UsuarioNullException extends AppMeRunTimeException {
    public UsuarioNullException(){
        super("Usuário não pode ser nulo");
    }
}
