package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_endereco_loja")
public class EnderecoLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco_loja")
    private Long id;

    @Column(name = "cep")
    @NotNull
    private BigInteger cep;

    @Column(name = "cidade")
    @NotNull
    private String cidade;

    @NotNull
    @Column(name = "uf")
    private String UF;

    @NotNull
    @Column(name = "rua")
    private String rua;

    @NotNull
    @Column(name = "bairro")
    private String bairro;

    @Column(name = "numero")
    private Integer numero;

}
