package com.inventario.sistemainventario.repository;

import com.inventario.sistemainventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
