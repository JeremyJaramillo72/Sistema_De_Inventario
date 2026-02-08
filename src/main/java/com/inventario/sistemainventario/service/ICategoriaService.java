package com.inventario.sistemainventario.service;


import com.inventario.sistemainventario.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    Categoria guardar(Categoria categoria);
    List<Categoria> listar();
    Categoria buscarPorId(Long id);
    void eliminar(Long id);
}
