package ar.edu.utn.frc.backend.TaskSpring.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frc.backend.TaskSpring.Models.Tarea;
import ar.edu.utn.frc.backend.TaskSpring.Repositories.TareaRepository;
import jakarta.annotation.PostConstruct;


@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;


    // Retorna una lista con todas las tareas
    public List<Tarea> getAllsTareas() {
        return tareaRepository.findAll();
    }

    // Retorna uan tarea por su ID, o null si no existe
    public Tarea GetIDTareas(Long id) {
        return tareaRepository.findById(id).orElse(null);

    }

    // Agrega uan nueva tarea Completando los valores faltantes y generando ID
    public Tarea agregarTarea(Tarea tarea) {
        if (tarea.getFechaLimite()  == null) {
            tarea.setFechaLimite(LocalDate.now().plusDays(7));
        }
        if (tarea.getPrioridad() == null) {
            tarea.setPrioridad(Tarea.Prioridad.BAJA);
        }
        return tareaRepository.save(tarea);
    }

    // Actualiza una tarea existente por su ID por el nuevo objeto
    public Tarea actualizarTarea(Long id, Tarea tarea) {
        tarea.setId(id);
        return tareaRepository.save(tarea);
    }

    // Elimina una tarea por su ID
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public List<Tarea> getTareasVencidas() {
        return tareaRepository.tareasVencidas(LocalDate.now());
    }

}
