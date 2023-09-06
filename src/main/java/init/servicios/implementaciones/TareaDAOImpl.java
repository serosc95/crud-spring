package init.servicios.implementaciones;

import init.entidades.Tarea;
import init.repositorios.TareaRepository;
import init.servicios.contratos.TareaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TareaDAOImpl implements TareaDAO {

    @Autowired
    private TareaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Tarea> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Tarea save(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Tarea> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
