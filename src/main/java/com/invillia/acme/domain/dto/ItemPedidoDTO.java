package com.invillia.acme.domain.dto;

import com.invillia.acme.domain.Pedido;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.math.BigInteger;

@Data
public class ItemPedidoDTO {


    @ApiModelProperty(notes = "Id do item Pedido")
    private Long id;

    @ApiModelProperty(notes = "Descrição do item Pedido")
    private String descricaoItem;

    @ApiModelProperty(notes = "Preço do item pedido")
    private Double preco;

    @ApiModelProperty(notes = "Quantidade de item pedido")
    private BigInteger quantidade;

    @ApiModelProperty(notes = "Pedido")
    private Pedido pedido;

}
