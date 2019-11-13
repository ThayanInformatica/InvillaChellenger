package com.invillia.acme.repository;

import com.invillia.acme.domain.EnderecoLoja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoLojaRepository extends JpaRepository<EnderecoLoja, Long> {
    EnderecoLoja findAllById(Long id);


}
