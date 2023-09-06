package init.servicios.contratos;

import init.entidades.Tarea;

import java.util.Optional;

public interface TareaDAO {

    Optional<Tarea> findById(Integer id);
    Tarea save(Tarea tarea);
    Iterable<Tarea> findAll();
    void deleteById(Integer id);

}
