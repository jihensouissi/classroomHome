package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.CoursClassroom;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {
}