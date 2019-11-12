package com.invillia.acme.service.impl;

import com.invillia.acme.domain.Loja;
import com.invillia.acme.repository.LojaRepository;
import com.invillia.acme.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LojaServiceImpl implements LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Loja cadastrarLoja(Loja loja) {
        if (loja.getId() != null) {

            Loja lojaAlterar = lojaRepository.findAllById(loja.getId());
        }

        this.lojaRepository.save(loja);

        return loja;
    }

}
