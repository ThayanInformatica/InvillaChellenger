package com.invillia.acme.controller;


import com.invillia.acme.domain.Usuario;
import com.invillia.acme.domain.dto.UsuarioDTO;
import com.invillia.acme.mapper.UsuarioMapper;
import com.invillia.acme.repository.UsuarioRepository;
import com.invillia.acme.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    @ApiOperation(value = "Adiciona um usuário")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid Usuario usuario) throws IOException {

        Usuario usuarios = usuarioService.cadastrarOuAlterarUsuario(usuario);

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuarios);

        return ResponseEntity.ok(usuarioDTO);

    }


}
