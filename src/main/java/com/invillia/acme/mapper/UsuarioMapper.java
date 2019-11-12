package com.invillia.acme.mapper;

import com.invillia.acme.domain.Usuario;
import com.invillia.acme.domain.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario usuario) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEnderecoUsuario(usuario.getEnderecoUsuario());

        return usuarioDTO;

    }
}