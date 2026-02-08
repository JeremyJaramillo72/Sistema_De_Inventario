package com.inventario.sistemainventario.controller;

import com.inventario.sistemainventario.model.Categoria;
import com.inventario.sistemainventario.service.ICategoriaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
@RequiredArgsConstructor
public class CategoriaController  implements Serializable {
    private final ICategoriaService categoriaService;


    private Categoria categoria;
    private List<Categoria> listaCategorias;

    @PostConstruct
    public void init() {
        this.categoria = new Categoria();
        cargarDatos();
    }

    public void cargarDatos() {
        this.listaCategorias = categoriaService.listar();
    }

    public void guardar() {
        try {
            categoriaService.guardar(categoria);
            mensaje("Éxito", "Categoría guardada correctamente");
            this.categoria = new Categoria(); // Limpiar
            cargarDatos(); // Recargar tabla
        } catch (Exception e) {
            mensaje("Error", "Error al guardar: " + e.getMessage());
        }
    }

    public void eliminar(Long id) {
        try {
            categoriaService.eliminar(id);
            mensaje("Eliminado", "Categoría eliminada");
            cargarDatos();
        } catch (Exception e) {
            mensaje("Error", "No se pudo eliminar");
        }
    }

    private void mensaje(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }
}
