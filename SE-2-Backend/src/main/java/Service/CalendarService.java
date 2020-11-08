package Service;

import Configs.GlobalVariables;
import Models.CalendarEntity;
import Repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    // Gets particular year and term calendar
    public List<CalendarEntity> getParticularCalendar(String year, Integer term) {
        return calendarRepository.findAllByYearAndTerm(year, term);
    }

    // Gets current year and term calendar
    public List<CalendarEntity> getCurrentCalendar() {
        GlobalVariables globalVariables = new GlobalVariables();
        String year = globalVariables.getYear();
        Integer term = globalVariables.getTerm();
        return calendarRepository.findAllByYearAndTerm(year, term);
    }
}
