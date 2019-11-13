package com.invillia.acme.repository;

import com.invillia.acme.domain.ReembolsoPedido;
import com.invillia.acme.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepository extends JpaRepository<ReembolsoPedido, Long> {

    ReembolsoPedido findAllById(Long id);

}
