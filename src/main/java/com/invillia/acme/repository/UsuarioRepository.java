package com.invillia.acme.repository;

import com.invillia.acme.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 ")
    Usuario findByEmail(String email);

    Usuario findAllById(Long id);

}
