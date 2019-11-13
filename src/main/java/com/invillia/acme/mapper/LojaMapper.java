package com.invillia.acme.mapper;

import com.invillia.acme.domain.Loja;
import com.invillia.acme.domain.dto.LojaDTO;
import com.invillia.acme.domain.dto.UsuarioDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class LojaMapper {

    public LojaDTO toDto(@RequestBody Loja loja) {

        LojaDTO lojaDTO = new LojaDTO();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(loja.getUsuario().getId());
        usuarioDTO.setEmail(loja.getUsuario().getEmail());
        usuarioDTO.setNome(loja.getUsuario().getNome());
        usuarioDTO.setEnderecoUsuario(loja.getUsuario().getEnderecoUsuario());

        lojaDTO.setNomeLoja(loja.getNomeLoja());
        lojaDTO.setUsuario(usuarioDTO);
        lojaDTO.setEnderecoLoja(loja.getEnderecoLoja());

        return lojaDTO;
    }
}