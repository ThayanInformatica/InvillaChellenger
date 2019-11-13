package com.invillia.acme.service.impl;

import com.invillia.acme.Exception.MessagesExcpetion.DataReembolsoExpiradaException;
import com.invillia.acme.Exception.MessagesExcpetion.PedidoNaoAprovadoException;
import com.invillia.acme.Exception.MessagesExcpetion.PedidoNullException;
import com.invillia.acme.Exception.MessagesExcpetion.UsuarioNullException;
import com.invillia.acme.domain.*;
import com.invillia.acme.domain.dto.PedidoDTO;
import com.invillia.acme.mapper.PedidoMapper;
import com.invillia.acme.repository.*;
import com.invillia.acme.service.PedidoService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Pedido solicitarPedido(Pedido pedido) {

        Usuario usuario = usuarioRepository.findAllById(pedido.getUsuario().getId());

        Loja loja = lojaRepository.findAllById(pedido.getLoja().getId());

        if (usuario == null) {
            throw new UsuarioNullException();
        }

        pedido.setUsuario(usuario);
        pedido.setLoja(loja);

        Pedido pedidoSave = pedidoRepository.save(pedido);

        pedido.getItensPedido().forEach(pedidos -> {
            Pedido pedidosRef = new Pedido();
            pedidosRef.setId(pedidoSave.getId());
            pedidos.setPedido(pedidosRef);
        });

        if (!pedido.getItensPedido().isEmpty()) {
            this.itemPedidoRepository.saveAll(pedidoSave.getItensPedido());
            this.itemPedidoRepository.flush();
        }

        return pedido;
    }

    @Override
    public Pedido aceitarPedido(Pedido pedido) {

        pedido.setStatus(true);

        pedido.getItensPedido().forEach(itensPedido -> {
            itensPedido.setStatus(true);
        });

        this.itemPedidoRepository.saveAll(pedido.getItensPedido());
        this.itemPedidoRepository.flush();

        this.pedidoRepository.save(pedido);

        return pedido;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PagamentoPedido pagamentoDoPedido(PagamentoPedido pagamentoPedido, Pedido pedido) {

        if (!pedido.getStatus()) {
            throw new PedidoNaoAprovadoException();
        }
        pagamentoPedido.setPedido(pedido);

        this.pagamentoRepository.save(pagamentoPedido);

        return pagamentoPedido;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ReembolsoPedido solicitarReembolso(ReembolsoPedido reembolsoPedido) {

        Pedido pedido = pedidoRepository.findAllById(reembolsoPedido.getPedido().getId());

        if (!pedido.getStatus()) {
            throw new PedidoNaoAprovadoException();
        }

        PedidoDTO pedidoDTO = pedidoMapper.toDto(pedido);

        Date dataConfirmacao = pedidoDTO.getDataConfirmacaoPedido();

        LocalDate dataConfirmacaoLocalDate = dataConfirmacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate dataHoje = LocalDate.now();

        long diferencaDias = ChronoUnit.DAYS.between(dataConfirmacaoLocalDate, dataHoje);

        if (diferencaDias > 10) {

            throw new DataReembolsoExpiradaException();
        }

        if (reembolsoPedido.getItensPedido().getId() != null) {
           ItensPedido itensPedido = itemPedidoRepository.findAllById(reembolsoPedido.getItensPedido().getId());
           if (pedido.getId().equals(itensPedido.getPedido().getId()) && itensPedido.getStatus()) {
               reembolsoPedido.setItensPedido(itensPedido);
           } else {
               throw new PedidoNullException();
           }
        }

        this.reembolsoRepository.save(reembolsoPedido);

        return reembolsoPedido;
    }

}
