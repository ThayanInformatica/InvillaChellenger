package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja")
    private Long id;

    @NotNull
    @Column(name = "nome_fantasia")
    private String nomeLoja;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @NotNull
    @OneToOne
    @JoinColumn(name="id_endereco_loja")
    private EnderecoLoja enderecoLoja;

    @OneToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;
}

