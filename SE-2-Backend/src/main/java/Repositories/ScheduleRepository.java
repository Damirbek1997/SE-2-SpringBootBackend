package Repositories;

import Models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByDepartmentIdAndYearAndTerm(Integer departmentId, String year, Integer term);
}
