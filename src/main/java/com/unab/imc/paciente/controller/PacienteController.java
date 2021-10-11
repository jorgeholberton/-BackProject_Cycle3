package com.unab.imc.paciente.controller;

import com.unab.imc.paciente.dto.PacienteDto;
import com.unab.imc.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDto> add(@RequestBody PacienteDto pacienteDto, BindingResult result) {
        try {
            pacienteService.add(pacienteDto);
            if (result.hasErrors()) {
                Logger.getLogger("ocurrio un error en la validacion");
            }
            return new ResponseEntity<>(pacienteDto, HttpStatus.OK);
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping
    public List<PacienteDto> getAll() {
        return pacienteService.getAll();
    }

    @GetMapping("/search")
    public PacienteDto getByNombre(@RequestBody PacienteDto pacienteDto) {
        return pacienteService.getByNombre(pacienteDto);
    }

    @PutMapping("/{id}")
    public PacienteDto update(@PathVariable int id, @RequestBody PacienteDto pacienteDto) {
        return pacienteService.update(id, pacienteDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        pacienteService.delete(id);
    }



}
