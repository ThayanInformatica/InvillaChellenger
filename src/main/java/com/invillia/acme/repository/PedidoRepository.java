package com.invillia.acme.repository;

import com.invillia.acme.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findAllById(Long id);

}
