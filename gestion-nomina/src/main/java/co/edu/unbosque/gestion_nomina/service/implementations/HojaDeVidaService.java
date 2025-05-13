package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVida;
import co.edu.unbosque.gestion_nomina.repository.nosql.HojaDeVidaRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHojaDeVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HojaDeVidaService implements IHojaDeVidaService {

    private final HojaDeVidaRepository repository;

    @Autowired
    public HojaDeVidaService(HojaDeVidaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void guardarHojaDeVida(HojaDeVida hojaDeVida) {
        repository.save(hojaDeVida);
    }

    @Override
    public List<HojaDeVida> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public List<HojaDeVida> buscarPorNombreODocumento(String keyword) {
        return repository.findByNumeroDocumentoContainingIgnoreCaseOrPrimerNombreContainingIgnoreCaseOrPrimerApellidoContainingIgnoreCase(
                keyword, keyword, keyword);
    }

    @Override
    public void eliminarPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public HojaDeVida buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }
}
