package com.invillia.acme.repository;

import com.invillia.acme.domain.EnderecoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, Long> {

}
