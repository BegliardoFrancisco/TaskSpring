package ar.edu.utn.frc.backend.TaskSpring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import ar.edu.utn.frc.backend.TaskSpring.Models.Persona;
import jakarta.annotation.PostConstruct;

@Service
public class PersonaService {
    
    private Map<Long, Persona> personas = new ConcurrentHashMap<>();
    private AtomicLong secuencia = new AtomicLong(1);

    @PostConstruct
    public void init() {
        // Inicializar con algunos datos de ejemplo
        personas.put(1L, new Persona(1L, "Ana", 30));
        personas.put(2L, new Persona(2L, "Juan", 25));
        personas.put(3L, new Persona(3L, "Lucia", 35));
        personas.put(4L, new Persona(4L, "Pedro", 28));
        personas.put(5L, new Persona(5L, "Sofia", 22));
    }

    public List<Persona> getAll() {
        return new ArrayList<>(personas.values());
    }

    public Persona getById(Long id) {
        return personas.get(id);
    }

    public Persona create(Persona persona) {
        Long id = secuencia.getAndIncrement();
        persona.setId(id);
        personas.put(id, persona);
        return persona;
    }

    public Persona update(Long id, Persona persona) {
        persona.setId(id);
        personas.put(id, persona);
        return persona;        
    }

    public void delete(Long id) {
        personas.remove(id);
    }
}
