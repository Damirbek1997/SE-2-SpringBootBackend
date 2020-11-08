package Controllers;

import Models.Grades;
import Service.GradesService;
import Service.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradesController {
    @Autowired
    private GradesService gradesService;

    // Post request to get grades according to particular term and year
    @RequestMapping(value = "/student/grades", method = RequestMethod.POST)
    public List<Grades> getParticularGrades(@AuthenticationPrincipal MyUserDetails myUserDetails,
                                            @RequestBody Grades grades) {
        return gradesService.getParticularGrades(myUserDetails.getId(), grades.getYear(), grades.getTerm());
    }

    // Get all grades according to current term and year
    @RequestMapping(value = "/student/grades", method = RequestMethod.GET)
    public List<Grades> getGrades(@AuthenticationPrincipal MyUserDetails myUserDetails) {
        return gradesService.getGrades(myUserDetails.getId());
    }

    // Get transcript
    @RequestMapping(value = "/student/transcript", method = RequestMethod.GET)
    public List<Grades> getTransciprt(@AuthenticationPrincipal MyUserDetails myUserDetails) {
        return gradesService.getTranscript(myUserDetails.getId());
    }
}
