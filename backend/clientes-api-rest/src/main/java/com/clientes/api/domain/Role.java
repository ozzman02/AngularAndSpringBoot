package com.clientes.api.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serial;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 1076416554027501198L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
