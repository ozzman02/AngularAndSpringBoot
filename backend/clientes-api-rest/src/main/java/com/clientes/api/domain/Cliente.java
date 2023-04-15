package com.clientes.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 7218176041440737996L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacío")
    @Column(nullable = false)
    private String apellido;

    @Email(message = "no es una dirección de correo válida")
    @NotEmpty(message = "no puede estar vacío")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "no puede estar vacío")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;


    private String foto;
    /*
        Vamos a incluir un datepicker en el frontend
    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }*/

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
