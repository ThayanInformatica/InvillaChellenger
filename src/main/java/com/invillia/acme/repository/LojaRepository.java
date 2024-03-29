package com.invillia.acme.repository;

import com.invillia.acme.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>,QueryByExampleExecutor<Loja> {

    Loja findAllById(Long id);

}
