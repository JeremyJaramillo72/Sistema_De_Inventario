package com.inventario.sistemainventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "tbCategoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoria")
    private Long IdCategoria;

    @NotBlank(message = "Debe ingresar un nombre  de la categoria")
    @Size(max = 50,message = "No se permite una categoria con un nombre tan grande")
    @Column(name = "NombreCategoria",nullable = false)
    private String nombreCategoria;

    @NotBlank(message = "Debe ingresar una descripción de la categoria")
    @Size(max = 75,message = "No se permite una descripcion  tan grande")
    @Column(name="Descripcion",nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Producto> productos;


}

