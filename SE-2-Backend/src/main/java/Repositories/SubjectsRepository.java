package Repositories;

import Models.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
    List<Subjects> findAllSubjectsByDepartmentsId(Integer subjectId);
}
