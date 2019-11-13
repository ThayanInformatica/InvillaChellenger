package com.invillia.acme.service.impl;

import com.invillia.acme.Exception.MessagesExcpetion.LojaNullException;
import com.invillia.acme.Exception.MessagesExcpetion.UsuarioNullException;
import com.invillia.acme.domain.ItensPedido;
import com.invillia.acme.domain.Loja;
import com.invillia.acme.domain.Usuario;
import com.invillia.acme.repository.EnderecoLojaRepository;
import com.invillia.acme.repository.ItemPedidoRepository;
import com.invillia.acme.repository.LojaRepository;
import com.invillia.acme.repository.UsuarioRepository;
import com.invillia.acme.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class LojaServiceImpl implements LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private EnderecoLojaRepository enderecoLojaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Loja cadastrarLoja(Loja loja) {

        Usuario usuario = usuarioRepository.findAllById(loja.getUsuario().getId());

        if (usuario == null) {
            throw new UsuarioNullException();
        }

        loja.setUsuario(usuario);

        this.enderecoLojaRepository.save(loja.getEnderecoLoja());

        this.lojaRepository.save(loja);

        return loja;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Loja atualizarLoja(Loja loja) {

        if (loja.getId() == null) {

            throw new LojaNullException();
        }

        if (loja.getUsuario().getId() == null) {
            throw new UsuarioNullException();
        }

        this.lojaRepository.save(loja);

        this.enderecoLojaRepository.save(loja.getEnderecoLoja());

        return loja;
    }

}
