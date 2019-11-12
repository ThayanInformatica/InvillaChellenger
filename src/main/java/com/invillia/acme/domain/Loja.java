package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "nome_fantasia")
    private String nomeLoja;

    @ManyToOne
    @JoinColumn(name="tb_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="tb_endereco_loja")
    private EnderecoLoja enderecoLoja;

}

