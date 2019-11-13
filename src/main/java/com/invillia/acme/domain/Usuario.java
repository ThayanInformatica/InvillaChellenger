package com.invillia.acme.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "usuarioseqGen", sequenceName = "seq_usuario", allocationSize = 1)
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioseqGen")
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank(message = "{name.not.blank}")
    @Column(name = "nome_completo")
    @NotNull
    private String nome;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    @Column(name = "email")
    @NotNull
    private String email;

    @NotBlank(message = "{senha.not.blank}")
    @NotNull
    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_endereco_usuario")
    private EnderecoUsuario enderecoUsuario;
}

