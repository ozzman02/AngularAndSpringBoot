package com.clientes.api.repository;

import com.clientes.api.domain.Cliente;
import com.clientes.api.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    List<Region> findAllRegions();

}
