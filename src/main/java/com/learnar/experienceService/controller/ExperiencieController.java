package com.learnar.experienceService.controller;


import com.learnar.experienceService.models.Experiences;
import com.learnar.experienceService.service.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/experience")
@RestController
public class ExperiencieController {

    @Autowired
    ExperienceServiceImpl experienceService;



    @GetMapping("/listar")
    public ResponseEntity <List<Experiences>> listarExperiencias() {
        List<Experiences> list=experienceService.listarExperiences();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping("/registrar")
    public Experiences registrarExperiencias(@RequestBody Experiences body) {
        return experienceService.registrarExperiences(body);
    }

    @PutMapping("/actualizar/{id}")
    public Experiences actualizar(@RequestBody Experiences body, @PathVariable("id") Long id) {
        return experienceService.actualizar(body, id);
    }

    @DeleteMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Long id) {
        return experienceService.eliminar(id);
    }

}

