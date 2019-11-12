package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "dt_confirmacao")
    private LocalDate dataConfirmacao;

    @ManyToOne
    @JoinColumn(name = "tb_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "tb_loja")
    private Loja loja;

    @OneToOne
    @JoinColumn(name = "tb_endereco_usuario")
    private EnderecoUsuario enderecoUsuario;

    @OneToOne
    @JoinColumn(name = "tb_item_pedido")
    private ItemPedido itemPedido;

    @OneToOne
    @JoinColumn(name = "tb_pagamento")
    private PagamentoPedido pagamentoPedido;

}
