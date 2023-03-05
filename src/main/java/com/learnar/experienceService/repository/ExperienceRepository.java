package com.learnar.experienceService.repository;



import com.learnar.experienceService.models.Experiences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experiences,Long> {
}
