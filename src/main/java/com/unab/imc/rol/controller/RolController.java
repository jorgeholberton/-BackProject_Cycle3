package com.unab.imc.rol.controller;

import com.unab.imc.rol.dto.RolDto;
import com.unab.imc.rol.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<RolDto> add(@RequestBody RolDto rolDto, BindingResult result) {
        try {
            rolService.add(rolDto);
            if (result.hasErrors()) {
                Logger.getLogger("ocurrio un error en la validacion");
            }
            return new ResponseEntity<>(rolDto, HttpStatus.OK);
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping
    public List<RolDto> getAll() {
        return rolService.getAll();
    }

    @GetMapping("/search")
    public RolDto getByNombre(@RequestBody RolDto rolDto) {
        return rolService.getByNombre(rolDto);
    }

    @PutMapping("/{id}")
    public RolDto update(@PathVariable int id, @RequestBody RolDto rolDto) {
        return rolService.update(id, rolDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        rolService.delete(id);
    }



}
