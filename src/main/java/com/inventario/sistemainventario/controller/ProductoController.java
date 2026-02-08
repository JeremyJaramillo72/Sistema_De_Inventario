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

    // el que implemente los metodos listar y guardar descomenta estas linea o lo adapta
//    @PostConstruct
//    public void init() {
//        producto = new Producto();
//        listaProductos = productoService.listar();
//        listaCategorias = categoriaService.listar();
//        listaEmpleados = empleadoRepository.findAll();
//    }

//    public void guardar() {
//        productoService.guardar(producto);
//        producto = new Producto();
//        listaProductos = productoService.listar();
//    }


    public Producto getProducto() { return producto; }
    public List<Producto> getListaProductos() { return listaProductos; }
    public List<Categoria> getListaCategorias() { return listaCategorias; }
    public List<Empleado> getListaEmpleados() { return listaEmpleados; }
}
