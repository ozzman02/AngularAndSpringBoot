package com.backend.chat.service;

import com.backend.chat.document.Mensaje;

import java.util.List;

public interface ChatService {

    List<Mensaje> obtenerUltimos10Mensajes();

    Mensaje guardarMensaje(Mensaje mensaje);

}
