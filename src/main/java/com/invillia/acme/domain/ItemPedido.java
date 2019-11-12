package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pedido")
    private Long id;

    @Column(name = "ds_item")
    private String descricaoItem;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade")
    private BigInteger quantidade;

    @OneToOne
    @JoinColumn(name = "tb_pedido")
    private Pedido pedido;

}
