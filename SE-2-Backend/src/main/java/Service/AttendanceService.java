package Service;

import Configs.GlobalVariables;
import Models.Attendance;
import Repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    // Finds in attendance table by email and gets exact year or term
    public List<Attendance> getUserAttendanceByYearAndTerm(String email, String year, Integer term) {
        return attendanceRepository.findByEmailAndYearAndTerm(email, year, term);
    }

    // Finds in attendance table by email of the current user
    public List<Attendance> getUserAttendanceByEmailCurrentDate(String email) {
        GlobalVariables globalVariables = new GlobalVariables(); // Gets current year and term
        String year = globalVariables.getYear();
        Integer term = globalVariables.getTerm();

        return attendanceRepository.findByEmailAndYearAndTerm(email, year, term);
    }
}
