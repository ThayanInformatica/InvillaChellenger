package com.invillia.acme.domain.dto;

import com.invillia.acme.domain.EnderecoUsuario;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Identificador do usuário")
    private Long id;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    @ApiModelProperty(notes = "Email do usuário")
    private String email;

    @ApiModelProperty(notes = "Endereco do usuário")
    private EnderecoUsuario enderecoUsuario;

}
