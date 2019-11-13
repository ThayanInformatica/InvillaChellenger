package com.invillia.acme.service.impl;

import com.invillia.acme.Exception.MessagesExcpetion.EmailExistenteException;
import com.invillia.acme.domain.Usuario;
import com.invillia.acme.repository.EnderecoUsuarioRepository;
import com.invillia.acme.repository.UsuarioRepository;
import com.invillia.acme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoUsuarioRepository enderecoUsuarioRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Usuario cadastrarOuAlterarUsuario(Usuario usuario) throws IOException {

        Usuario validarEmail = usuarioRepository.findByEmail(usuario.getEmail());

        if (validarEmail != null) {

            throw new EmailExistenteException();
        }

        if (usuario.getId() != null) {

            Usuario usuarioid = usuarioRepository.findAllById(usuario.getId());
        }

        this.usuarioRepository.save(usuario);

        if (usuario.getEnderecoUsuario() != null) {
            this.enderecoUsuarioRepository.save(usuario.getEnderecoUsuario());
        }
        this.usuarioRepository.save(usuario);

        return usuario;
    }



}
