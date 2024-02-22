package com.practica.empleadosbackend.controllers;

import com.practica.empleadosbackend.entities.Empleado;
import com.practica.empleadosbackend.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

@Autowired
    private EmpleadoService empleadoService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("list", empleadoService.buscar());
        return "index";

    }

    @PostMapping("/guardar")
    public String save(Empleado empleado, Model model) {

        empleadoService.guardar(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("/guardar/{id}")
    public String showSave(@PathVariable("id") String id, Model model) {

        if (id != null && !"0".equals(id)) {
            model.addAttribute("empleado", empleadoService.buscarPorId(id));
        } else {
            model.addAttribute("empleado", new Empleado());
        }

        return "guardar";

    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        empleadoService.eliminar(id);
        return "redirect:/empleado";
    }
}
