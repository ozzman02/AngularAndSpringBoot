package com.clientes.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Serial
    private static final long serialVersionUID = 7261662328798054652L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String observacion;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"facturas", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ItemFactura> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public Double getTotal() {
        return items.stream()
                .mapToDouble(ItemFactura::getImporte)
                .sum();
    }
}
