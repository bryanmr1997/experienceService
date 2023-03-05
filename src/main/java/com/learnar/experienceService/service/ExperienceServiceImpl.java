package com.learnar.experienceService.service;




import com.learnar.experienceService.models.Experiences;
import com.learnar.experienceService.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements IExperienceService {

    @Autowired
    private ExperienceRepository ExperienceRepository;


    @Override
    public List<Experiences> listarExperiences() {
        return ExperienceRepository.findAll();
    }

    @Override
    public Experiences registrarExperiences(Experiences body) {
        Experiences nuevo=new Experiences(body.getName(), body.getDescription(), "ENABLED");

        return ExperienceRepository.save(nuevo);
    }

    @Override
    public Experiences actualizar(Experiences body, Long id) {

        Optional<Experiences> Experiences=ExperienceRepository.findById(id);
        if(Experiences.isPresent()){
            Experiences ExperiencesActualizado=Experiences.get();

            ExperiencesActualizado.setName(body.getName());
            ExperiencesActualizado.setDescription(body.getDescription());

            ExperienceRepository.save(ExperiencesActualizado);
        }
        return null;
    }

    @Override
    public String eliminar(Long idExperiences) {

        Optional<Experiences> encontrado=ExperienceRepository.findById(idExperiences);

        if(encontrado.isPresent()){

                Experiences experienceDisabled=encontrado.get();
                experienceDisabled.setState("DISABLED");
                ExperienceRepository.save(experienceDisabled);
                return "Experiencia deshabilitada";
        }

        return "No se encontro el id";
    }
}
