package com.invillia.acme.repository;

import com.invillia.acme.domain.PagamentoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoPedido, Long> {
    PagamentoPedido findAllById(Long id);

    @Query(value = " SELECT p " +
            " FROM PagamentoPedido p " +
            " WHERE p.pedido.id = :id")
    PagamentoPedido encontrarPagamentoDePedidoPorIdPedido(@Param("id") Long id);
}
