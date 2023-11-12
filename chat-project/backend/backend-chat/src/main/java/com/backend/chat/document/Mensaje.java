package com.backend.chat.document;

import java.io.Serializable;

public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1887057818572844694L;

    private String texto;

    private Long fecha;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
}
