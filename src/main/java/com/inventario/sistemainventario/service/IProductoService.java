package com.inventario.sistemainventario.service;

import com.inventario.sistemainventario.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto guardar(Producto producto);
    List<Producto> listar();
    Producto buscarPorId(Long id);
    void eliminar(Long id);
}
