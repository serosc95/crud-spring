package init.repositorios;

import init.entidades.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Integer> {
}
