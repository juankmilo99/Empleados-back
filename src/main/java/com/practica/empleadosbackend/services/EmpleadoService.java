package com.practica.empleadosbackend.services;

import com.practica.empleadosbackend.entities.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> buscar();

    Empleado buscarPorId(String id);

    Empleado guardar(Empleado empleado);

    void eliminar(String id);
}
