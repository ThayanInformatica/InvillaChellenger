package com.invillia.acme.controller;


import com.invillia.acme.domain.ItensPedido;
import com.invillia.acme.domain.Loja;
import com.invillia.acme.domain.dto.LojaDTO;
import com.invillia.acme.mapper.LojaMapper;
import com.invillia.acme.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @Autowired
    private LojaMapper lojaMapper;

    @PostMapping
    public ResponseEntity<LojaDTO> cadastrarLoja(@RequestBody Loja loja) {

        Loja lojaCadastro = lojaService.cadastrarLoja(loja);

        LojaDTO lojaDTO = lojaMapper.toDto(lojaCadastro);

        return new ResponseEntity<>(lojaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/atualizar-loja")
    public ResponseEntity<LojaDTO> atualizarLojaApi(@RequestBody Loja loja) {

        Loja lojaCadastro = lojaService.atualizarLoja(loja);

        LojaDTO lojaDTO = lojaMapper.toDto(lojaCadastro);

        return new ResponseEntity<>(lojaDTO, HttpStatus.CREATED);
    }

}
