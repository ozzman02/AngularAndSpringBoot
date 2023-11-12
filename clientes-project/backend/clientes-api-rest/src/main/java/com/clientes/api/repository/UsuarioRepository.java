package com.clientes.api.repository;

import com.clientes.api.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    /* ejemplo con jpql
    @Query("select u from Usuario u where u.username = ?1")
    Usuario findByUsername2(String username);*/

}
