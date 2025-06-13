package ar.edu.utn.frc.backend.TaskSpring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frc.backend.TaskSpring.Services.TareaService;
import ar.edu.utn.frc.backend.TaskSpring.Models.Tarea;
import java.util.List;

@RestController 
@RequestMapping("/api/tareas")
public class TareasController {
    
    @Autowired
    private TareaService tareaService;

    @GetMapping List<Tarea> listar() {return tareaService.getAllsTareas();}

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable Long id) {
        return tareaService.GetIDTareas(id);
    }

    @PostMapping
    public Tarea create(@RequestBody Tarea tarea) {
        return tareaService.agregarTarea(tarea); 
    }
    
    @PutMapping("/{id}")
    public Tarea update(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }

    @GetMapping("/vencidas")
    public List<Tarea> tareasVencidas() {
        return tareaService.getTareasVencidas();
    }
}
