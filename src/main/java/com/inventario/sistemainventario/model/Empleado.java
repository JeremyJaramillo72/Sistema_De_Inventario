package com.inventario.sistemainventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tbEmpleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long idEmpleado;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50)
    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @NotBlank(message = "El cargo es obligatorio")
    @Column(name = "Cargo")
    private String cargo;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Producto> productosRegistrados;

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
