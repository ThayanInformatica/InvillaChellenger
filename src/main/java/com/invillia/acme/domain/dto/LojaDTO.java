package com.invillia.acme.domain.dto;

import com.invillia.acme.domain.EnderecoLoja;
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
public class LojaDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(notes = "Nome da loja")
    private String nomeLoja;

    @ApiModelProperty(notes = "Nome da loja")
    private UsuarioDTO usuarioDTO;

    @ApiModelProperty(notes = "Endereco da loja")
    private EnderecoLoja enderecoLoja;

}
