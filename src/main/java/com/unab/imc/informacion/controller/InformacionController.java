package com.unab.imc.informacion.controller;

import com.unab.imc.informacion.dto.InformacionDto;
import com.unab.imc.informacion.service.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/informacion")
public class InformacionController {

    @Autowired
    private InformacionService informacionService;

    @CrossOrigin(origins = "https://carontestudio.com/")
    @PostMapping
    public ResponseEntity<InformacionDto> add(@RequestBody InformacionDto informacionDto, BindingResult result) {
        try {
            informacionService.add(informacionDto);
            if (result.hasErrors()) {
                Logger.getLogger("ocurrio un error en la validacion");
            }
            return new ResponseEntity<>(informacionDto, HttpStatus.OK);
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("El numero ingresado no es un decimal");
        }
    }

    @GetMapping
    public List<InformacionDto> getAll(Model model) {

        return informacionService.getAll();
    }


    @PutMapping("/{id}")
    public InformacionDto update(@PathVariable String id, @RequestBody InformacionDto informacionDto) {
        return informacionService.update(id, informacionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        informacionService.delete(id);
    }


}
