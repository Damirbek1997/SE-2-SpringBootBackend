package Repositories;

import Models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByEmailAndYearAndTerm(String email, String year, Integer Term);
}
