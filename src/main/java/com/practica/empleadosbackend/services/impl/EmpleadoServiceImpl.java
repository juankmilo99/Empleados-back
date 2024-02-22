package com.practica.empleadosbackend.services.impl;

import com.practica.empleadosbackend.entities.Empleado;
import com.practica.empleadosbackend.repository.EmpleadoRepository;
import com.practica.empleadosbackend.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
@Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> buscar() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarPorId(String id) {

        Optional<Empleado> empl = empleadoRepository.findById(id);
        if(empl.isPresent()) {
            return empl.get();
        }
        return null;
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(String id) {
        empleadoRepository.deleteById(id);
    }
}
