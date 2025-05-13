package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVida;

import java.util.List;

public interface IHojaDeVidaService {

    void guardarHojaDeVida(HojaDeVida hojaDeVida);
    List<HojaDeVida> buscarTodas();
    List<HojaDeVida> buscarPorNombreODocumento(String keyword);
    void eliminarPorId(String id);
    HojaDeVida buscarPorId(String id);
}
