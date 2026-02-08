package com.inventario.sistemainventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbProducto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @NotBlank(message = "Ingrese un nombre del producto")
    @Size(max = 50,message = "Ingrese un nombre de producto mas corto")
    @Column(name = "NombreProducto")
    private String nombreProducto;

    @NotNull(message = "El stock es obligatorio,ingreselo por favor")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(name = "Stock")
    private Long stock;


    @NotNull(message = "El precio es obligatorio,ingreselo por favor")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(name = "Precio")
    private double  precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
}
