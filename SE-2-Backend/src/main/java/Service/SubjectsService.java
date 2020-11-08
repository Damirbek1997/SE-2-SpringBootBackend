package Service;

import Models.Subjects;
import Repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {
    @Autowired
    private SubjectsRepository subjectsRepository;

    // Get all subjects that corresponds to user department
    public List<Subjects> getAllByDepartmentId(Integer departmentId) {
        return subjectsRepository.findAllSubjectsByDepartmentsId(departmentId);
    }
}
