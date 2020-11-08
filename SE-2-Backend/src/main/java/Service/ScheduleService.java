package Service;

import Configs.GlobalVariables;
import Models.Schedule;
import Repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    // Gets schedule particular term and year
    public List<Schedule> getParticularSchedule(Integer departmentId, String year, Integer term) {
        return scheduleRepository.findAllByDepartmentIdAndYearAndTerm(departmentId, year, term);
    }

    // Gets schedule according to current term and year
    public List<Schedule> getSchedule(Integer departmentId) {
        GlobalVariables globalVariables = new GlobalVariables();
        String year = globalVariables.getYear();
        Integer term = globalVariables.getTerm();
        return scheduleRepository.findAllByDepartmentIdAndYearAndTerm(departmentId, year, term);
    }
}
