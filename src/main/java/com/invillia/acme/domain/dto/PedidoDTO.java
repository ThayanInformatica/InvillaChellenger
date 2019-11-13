package com.invillia.acme.domain.dto;

import com.invillia.acme.domain.ItensPedido;
import com.invillia.acme.domain.PagamentoPedido;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Status do pedido")
    private Boolean statusPedido;

    @ApiModelProperty(notes = "Status do pedido")
    private Date dataConfirmacaoPedido;

    @ApiModelProperty(notes = "Usuario que solicitou o pedido")
    private UsuarioDTO usuarioSolicitouPedido;

    @ApiModelProperty(notes = "Loja do Pedido")
    private LojaDTO loja;

    @ApiModelProperty(notes = "Items pedido")
    private List<ItensPedido> itensPedido;

    @ApiModelProperty(notes = "Nome da loja")
    private PagamentoPedido pagamentoPedido;

}
