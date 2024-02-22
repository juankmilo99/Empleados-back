package com.practica.empleadosbackend.repository;

import com.practica.empleadosbackend.entities.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {

}
