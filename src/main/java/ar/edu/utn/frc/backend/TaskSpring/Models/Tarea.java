package ar.edu.utn.frc.backend.TaskSpring.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tarea")
public class Tarea {

    
    // Identificador único de la tarea
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  Descripción de la tarea (Detalle textual)
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min=5, message = "La descripción debe tener al menos 5 caracteres")
    @Column(name = "descripcion")
    private String descripcion;
    
    // Indicador de la tarea para ver si fue completada
    @Column(name = "completada")
    private boolean completada;
    
    //FechaLimite para finalziar la y tarea
    @Column(name = "fecha_limite")
    @Future(message = "La fecha límite debe ser una fecha futura")
    private LocalDate fechaLimite;

    //Nivel de rioridad enum(interno)
    @NotNull(message= "La prioridad no puede ser nula")
    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad")
    private Prioridad prioridad;

    // Enumeraciones para las prioridades de las tareas
    public enum Prioridad {
        BAJA, MEDIA, ALTA
    }


}
