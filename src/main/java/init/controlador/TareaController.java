package init.controlador;

import init.entidades.Tarea;
import init.servicios.contratos.TareaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaDAO tareaDAO;
    @Autowired
    public TareaController(TareaDAO tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Tarea> tareas = (List<Tarea>) tareaDAO.findAll();
        if(tareas.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", "No se ha creado ninguna tarea");
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("datos", tareas);
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Tarea> oCarrera = tareaDAO.findById(id);
        if(oCarrera.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existe la tarea con el ID %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("datos", oCarrera.get());
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea){
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("datos", tareaDAO.save(tarea));
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarea(@PathVariable Integer id, @RequestBody Tarea tarea){
        Map<String, Object> mensaje = new HashMap<>();
        Tarea tareaUpdate = null;
        Optional<Tarea> oCarrera = tareaDAO.findById(id);

        if(oCarrera.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existe la tarea con el ID %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        tareaUpdate = oCarrera.get();
        tareaUpdate.setEstado(tarea.getEstado());

        mensaje.put("datos", tareaDAO.save(tareaUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Integer id) {
        tareaDAO.deleteById(id);
    }

}
