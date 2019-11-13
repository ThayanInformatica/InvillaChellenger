package com.invillia.acme.controller;


import com.invillia.acme.Exception.MessagesExcpetion.PedidoNullException;
import com.invillia.acme.domain.PagamentoPedido;
import com.invillia.acme.domain.Pedido;
import com.invillia.acme.domain.ReembolsoPedido;
import com.invillia.acme.domain.dto.PedidoDTO;
import com.invillia.acme.mapper.PedidoMapper;
import com.invillia.acme.repository.PedidoRepository;
import com.invillia.acme.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody Pedido pedido) {

        Pedido pedidoSolicitado = pedidoService.solicitarPedido(pedido);

        PedidoDTO pedidoDTO = pedidoMapper.toDto(pedidoSolicitado);

        return new ResponseEntity<>(pedidoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/aceitar-pedido")
    public ResponseEntity<PedidoDTO> aceitarPedido(@RequestBody Pedido pedido) {

        Pedido pedidoEncontrado = pedidoRepository.findAllById(pedido.getId());

        if (pedidoEncontrado == null) {
            throw new PedidoNullException();
        }

        Pedido pedidoAceito = pedidoService.aceitarPedido(pedidoEncontrado);

        PedidoDTO pedidoDTO = pedidoMapper.toDto(pedidoAceito);

        return ResponseEntity.ok(pedidoDTO);
    }

    @PostMapping("/pagamento-pedido")
    public ResponseEntity<PagamentoPedido> PagamentoPedido(@RequestBody PagamentoPedido pagamentoPedido) {

        Pedido pedidoEncontrado = pedidoRepository.findAllById(pagamentoPedido.getPedido().getId());

        if (pedidoEncontrado == null) {
            throw new PedidoNullException();
        }

        PagamentoPedido pagamentoPedidoSave = pedidoService.pagamentoDoPedido(pagamentoPedido, pedidoEncontrado);

        return ResponseEntity.ok(pagamentoPedidoSave);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> recuperarPedidoPorId(
            @PathVariable("idPedido") Long idPedido) {

        Pedido pedido = pedidoRepository.findAllById(idPedido);

        if (pedido == null)
            throw new PedidoNullException();

        return ResponseEntity.ok(pedidoMapper.toDto(pedido));
    }

    @PostMapping("/solicitar-reembolso")
    public ResponseEntity<ReembolsoPedido> reembolsoDePedidoOuItemPedido(@RequestBody ReembolsoPedido reembolsoPedido) {

        if (reembolsoPedido.getPedido().getId() == null) {
            throw new PedidoNullException();
        }

        ReembolsoPedido reembolsoPedidoSalvo = pedidoService.solicitarReembolso(reembolsoPedido);

        return new ResponseEntity<>(reembolsoPedidoSalvo, HttpStatus.CREATED);
    }


}
