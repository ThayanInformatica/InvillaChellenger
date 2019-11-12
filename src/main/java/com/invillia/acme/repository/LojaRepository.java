package com.invillia.acme.repository;

import com.invillia.acme.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

    Loja findAllById(Long id);

}
