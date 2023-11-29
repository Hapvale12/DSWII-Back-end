package pe.com.dswii.Asistencia.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.dswii.Asistencia.domain.Schedule;
import pe.com.dswii.Asistencia.domain.dto.ScheduleDTO;
import pe.com.dswii.Asistencia.domain.ScheduleDetail;
import pe.com.dswii.Asistencia.domain.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    @Transactional
    public Schedule save(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        List<ScheduleDetail> details = new ArrayList<>();
        for (int i=0; i < scheduleDTO.getStudents().length; i++){
            ScheduleDetail detail = new ScheduleDetail();
            detail.setDetailId((i + 1));
            detail.setStudentId(scheduleDTO.getStudents()[i]);
            details.add(detail);
        }
        schedule.setDetails(details);
        return  scheduleRepository.save(schedule);
    }
    public Optional<List<Schedule>> getByProfessorId(Integer teacherId) {
        return scheduleRepository.getByProfessorId(teacherId);
    }

    public Optional<Schedule> getById(Integer id) {
        return scheduleRepository.getById(id);
    }
    public List<Schedule> getAll() {return scheduleRepository.getAll();}

    public List<ScheduleDetail> getByScheduleId(Integer scheduleId) {
        return scheduleRepository.getByScheduleId(scheduleId);
    }
}