package com.invillia.acme.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "tb_item_pedido")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pedido")
    private Long id;

    @Column(name = "ds_item")
    private String descricaoItem;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "quantidade")
    private BigInteger quantidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
