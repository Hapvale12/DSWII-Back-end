package pe.com.dswii.Asistencia.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.dswii.Asistencia.domain.Schedule;
import pe.com.dswii.Asistencia.domain.dto.ScheduleDTO;
import pe.com.dswii.Asistencia.domain.ScheduleDetail;
import pe.com.dswii.Asistencia.domain.dto.ScheduleDetailDTO;
import pe.com.dswii.Asistencia.domain.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule save(@RequestBody @Valid ScheduleDTO scheduleDTO) {
        return  scheduleService.save(scheduleDTO);
    }

    @GetMapping("teacher/{teacherId}")
    public ResponseEntity<List<Schedule>> getByProfessorId(@PathVariable Integer teacherId) {
        return ResponseEntity.of(scheduleService.getByProfessorId(teacherId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Schedule> getAll() {
        return scheduleService.getAll();
    }

    @GetMapping("{scheduleId}")
    public ResponseEntity<List<ScheduleDetailDTO>> getDetailByScheduleId(@PathVariable int scheduleId) {
        return new ResponseEntity<>(scheduleService.getByScheduleId(scheduleId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Schedule>> delete(@PathVariable("id") int scheduleId){
        scheduleService.delete(scheduleId);
        return new ResponseEntity<>(scheduleService.getAllActive(), HttpStatus.OK);
    }




}
