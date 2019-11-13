package com.invillia.acme.repository;

import com.invillia.acme.domain.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItensPedido, Long>, QueryByExampleExecutor<ItensPedido> {

    ItensPedido findAllById(Long id);

}
