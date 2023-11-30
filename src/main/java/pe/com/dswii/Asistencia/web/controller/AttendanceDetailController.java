package pe.com.dswii.Asistencia.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.dswii.Asistencia.domain.dto.AttendanceDetailDTO;
import pe.com.dswii.Asistencia.domain.service.AttendanceDetailService;

import java.util.List;

@RestController
@RequestMapping("/attendancesDetails")
@AllArgsConstructor
public class AttendanceDetailController {

    private final AttendanceDetailService attendanceDetailService;

    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<List<AttendanceDetailDTO>> findDetailsForStudent(@PathVariable("studentId") int studentId){
        return new ResponseEntity<>(attendanceDetailService.findDetailsForStudent(studentId), HttpStatus.OK);
    }
}
