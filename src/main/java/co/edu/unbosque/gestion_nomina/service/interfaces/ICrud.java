package co.edu.unbosque.gestion_nomina.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface ICrud <T,K> {

    void create(T objetoDTO);
    Optional<T> find(K id);
    void update(K id, T objetoDTO);
    void delete(K id);
    List<T> findAll();
}
