package com.inventario.sistemainventario.repository;

import com.inventario.sistemainventario.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
}
