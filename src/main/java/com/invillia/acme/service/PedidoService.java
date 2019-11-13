package com.invillia.acme.service;

import com.invillia.acme.domain.PagamentoPedido;
import com.invillia.acme.domain.Pedido;
import com.invillia.acme.domain.ReembolsoPedido;
import com.invillia.acme.domain.Usuario;

import java.io.IOException;

public interface PedidoService {

    Pedido solicitarPedido(Pedido pedido);

    Pedido aceitarPedido(Pedido pedido);

    PagamentoPedido pagamentoDoPedido(PagamentoPedido pagamentoPedido, Pedido pedido);

    ReembolsoPedido solicitarReembolso(ReembolsoPedido reembolsoPedido);


}
