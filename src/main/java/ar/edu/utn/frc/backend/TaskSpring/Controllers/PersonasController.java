package ar.edu.utn.frc.backend.TaskSpring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frc.backend.TaskSpring.Models.Persona;
import ar.edu.utn.frc.backend.TaskSpring.Services.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonasController {


    @Autowired
    private PersonaService personaService;


    @GetMapping() List<Persona> getalls() {return personaService.getAll();}

    @GetMapping("/{id}")
    public Persona getById(@PathVariable Long id) {
        return personaService.getById(id);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, Persona persona) {
        return personaService.update(id, persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }

}
