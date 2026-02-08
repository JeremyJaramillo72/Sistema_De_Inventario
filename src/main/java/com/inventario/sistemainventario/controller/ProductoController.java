package com.inventario.sistemainventario.controller;

import com.inventario.sistemainventario.model.Categoria;
import com.inventario.sistemainventario.model.Empleado;
import com.inventario.sistemainventario.model.Producto;
import com.inventario.sistemainventario.repository.IEmpleadoRepository;
import com.inventario.sistemainventario.service.ICategoriaService;
import com.inventario.sistemainventario.service.IProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ProductoController implements Serializable {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    private Producto producto;
    private List<Producto> listaProductos;
    private List<Categoria> listaCategorias;
    private List<Empleado> listaEmpleados;

    @PostConstruct
    public void init() {
        this.producto = new Producto();
        cargarDatos();
        cargarListas();
    }

    public void cargarDatos() {
        this.listaProductos = productoService.listar();
    }

    public void cargarListas() {
        this.listaCategorias = categoriaService.listar();
        this.listaEmpleados = empleadoRepository.findAll();
    }

    public void guardar() {
        try {
            if (producto.getCategoria() == null || producto.getEmpleado() == null) {
                mensaje("Error", "Debe seleccionar Categoría y Empleado");
                return;
            }
            productoService.guardar(producto);
            mensaje("Éxito", "Producto registrado correctamente");
            this.producto = new Producto();
            cargarDatos();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje("Error", "Error al guardar: " + e.getMessage());
        }
    }

    public void eliminar(Long id) {
        try {
            productoService.eliminar(id);
            mensaje("Eliminado", "Producto eliminado correctamente");
            cargarDatos();
        } catch (Exception e) {
            mensaje("Error", "No se pudo eliminar");
        }
    }

    private void mensaje(String resumen, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle));
    }


    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public List<Producto> getListaProductos() { return listaProductos; }
    public void setListaProductos(List<Producto> listaProductos) { this.listaProductos = listaProductos; }

    public List<Categoria> getListaCategorias() { return listaCategorias; }
    public void setListaCategorias(List<Categoria> listaCategorias) { this.listaCategorias = listaCategorias; }

    public List<Empleado> getListaEmpleados() { return listaEmpleados; }
    public void setListaEmpleados(List<Empleado> listaEmpleados) { this.listaEmpleados = listaEmpleados; }


}
