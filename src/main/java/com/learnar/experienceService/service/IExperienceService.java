package com.learnar.experienceService.service;



import com.learnar.experienceService.models.Experiences;

import java.util.List;

public interface IExperienceService {




    List<Experiences> listarExperiences();

    Experiences registrarExperiences(Experiences body);

    Experiences actualizar(Experiences body, Long id);

    String eliminar(Long idExperiencie);
}
