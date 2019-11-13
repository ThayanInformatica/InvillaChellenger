package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class PedidoNullException extends AppMeRunTimeException {
    public PedidoNullException(){
        super("Pedido não encontrado");
    }
}
