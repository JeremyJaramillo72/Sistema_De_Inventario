package com.inventario.sistemainventario.service.impl;

import com.inventario.sistemainventario.model.Categoria;
import com.inventario.sistemainventario.repository.ICategoriaRepository;
import com.inventario.sistemainventario.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaImpl implements ICategoriaService {
    private final ICategoriaRepository categoriaRepository;

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id=" + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("No existe categoría con id=" + id);
        }
        categoriaRepository.deleteById(id);
    }
}
