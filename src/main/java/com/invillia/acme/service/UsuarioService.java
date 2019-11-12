package com.invillia.acme.service;

import com.invillia.acme.domain.Usuario;

import java.io.IOException;

public interface UsuarioService {

    Usuario cadastrarOuAlterarUsuario(Usuario usuario) throws IOException;

}
