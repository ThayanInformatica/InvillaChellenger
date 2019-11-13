package com.invillia.acme.Exception.MessagesExcpetion;


import com.invillia.acme.Exception.AppMeRunTimeException;

public class PedidoNaoAprovadoException extends AppMeRunTimeException {
    public PedidoNaoAprovadoException(){
        super("O Pedido deve ser aprovado!");
    }
}
