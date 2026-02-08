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

import java.io.Serializable;
import java.util.List;

@Named("productoController")
@ViewScoped
public class ProductoController implements Serializable {

    @Inject
    private IProductoService productoService;

    @Inject
    private ICategoriaService categoriaService;

    @Inject
    private IEmpleadoRepository empleadoRepository;

    private Producto producto;

    private List<Producto> listaProductos;
    private List<Categoria> listaCategorias;
    private List<Empleado> listaEmpleados;


    @PostConstruct

    public void init() {
        producto = new Producto();
        listaProductos = productoService.listar();
        listaCategorias = categoriaService.listar();
        listaEmpleados = empleadoRepository.findAll();
    }


    public void guardar() {
        productoService.guardar(producto);
        producto = new Producto();
        listaProductos = productoService.listar();
    }





    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
