package com.backend.chat.repository;

import com.backend.chat.document.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends MongoRepository<Mensaje, String> {

    List<Mensaje> findFirst10ByOrderByFechaDesc();
}
