package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_reembolso")
public class ReembolsoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reembolso")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_item_pedido")
    private ItensPedido itensPedido;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
