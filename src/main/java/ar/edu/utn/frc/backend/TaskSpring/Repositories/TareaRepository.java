package ar.edu.utn.frc.backend.TaskSpring.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.utn.frc.backend.TaskSpring.Models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

    @Query("SELECT t FROM Tarea t WHERE t.fechaLimite < :fecha AND t.completada = false")
    List<Tarea> tareasVencidas(@Param("fecha") LocalDate fecha);
    
}
