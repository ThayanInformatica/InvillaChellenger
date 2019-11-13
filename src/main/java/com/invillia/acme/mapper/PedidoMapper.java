package com.invillia.acme.mapper;

import com.invillia.acme.domain.PagamentoPedido;
import com.invillia.acme.domain.Pedido;
import com.invillia.acme.domain.dto.LojaDTO;
import com.invillia.acme.domain.dto.PedidoDTO;
import com.invillia.acme.domain.dto.UsuarioDTO;
import com.invillia.acme.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;


@Component
public class PedidoMapper {

    @Autowired
    private LojaMapper lojaMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PedidoDTO toDto(@RequestBody Pedido pedido) {

        PedidoDTO pedidoDTO = new PedidoDTO();

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(pedido.getUsuario());
        LojaDTO lojaDTO = lojaMapper.toDto(pedido.getLoja());

        pedidoDTO.setDataConfirmacaoPedido(pedido.getDataConfirmacao());
        pedidoDTO.setStatusPedido(pedido.getStatus());
        pedidoDTO.setLoja(lojaDTO);
        pedidoDTO.setUsuarioSolicitouPedido(usuarioDTO);
        pedidoDTO.setItensPedido(pedido.getItensPedido());

        PagamentoPedido pagamentoPedido = pagamentoRepository.encontrarPagamentoDePedidoPorIdPedido(pedido.getId());

        if (pagamentoPedido != null) {
           pedidoDTO.setPagamentoPedido(pagamentoPedido);
        }

        return pedidoDTO;
    }
}