package pe.com.dswii.Asistencia.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.dswii.Asistencia.domain.Attendance;
import pe.com.dswii.Asistencia.domain.dto.AttendanceDTO;
import pe.com.dswii.Asistencia.domain.service.AttendanceService;

import java.util.Arrays;

@RestController
@RequestMapping("attendances")
@AllArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance save(@RequestBody AttendanceDTO attendanceDTO) {
        System.out.println(attendanceDTO.getTitle());
        for (int i = 0; i < attendanceDTO.getMissing().length; i++) {
            System.out.println(Arrays.stream(attendanceDTO.getMissing()).toArray()[i].toString());
        }
        System.out.println(attendanceDTO.getScheduleId());
        System.out.println(attendanceDTO.getUserId());
        return attendanceService.save(attendanceDTO);
    }
}
