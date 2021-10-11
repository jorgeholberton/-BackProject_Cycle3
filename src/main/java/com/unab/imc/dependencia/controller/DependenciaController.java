package com.unab.imc.dependencia.controller;

import com.unab.imc.dependencia.dto.DependenciaDto;
import com.unab.imc.dependencia.service.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/dependencia")
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;

    @PostMapping
    public ResponseEntity<DependenciaDto> add(@RequestBody DependenciaDto dependenciaDto, BindingResult result) {
        try {
            dependenciaService.add(dependenciaDto);
            if (result.hasErrors()) {
                Logger.getLogger("ocurrio un error en la validacion");
            }
            return new ResponseEntity<>(dependenciaDto, HttpStatus.OK);
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping
    public List<DependenciaDto> getAll() {
        return dependenciaService.getAll();
    }

    @GetMapping("/search")
    public DependenciaDto getByNombre(@RequestBody DependenciaDto pacienteDto) {
        return dependenciaService.getByNombre(pacienteDto);
    }

    @PutMapping("/{id}")
    public DependenciaDto update(@PathVariable int id, @RequestBody DependenciaDto pacienteDto) {
        return dependenciaService.update(id, pacienteDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dependenciaService.delete(id);
    }



}
