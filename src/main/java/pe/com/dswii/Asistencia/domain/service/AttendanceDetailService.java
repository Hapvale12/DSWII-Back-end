package pe.com.dswii.Asistencia.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pe.com.dswii.Asistencia.domain.AttendanceDetail;
import pe.com.dswii.Asistencia.domain.dto.AttendanceDetailDTO;
import pe.com.dswii.Asistencia.domain.repository.AttendanceDetailRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceDetailService {

    private final AttendanceDetailRepository attendanceDetailRepository;

    public List<AttendanceDetailDTO> findDetailsForStudent(@Param("studentId") int studentId){
        return attendanceDetailRepository.findDetailsForStudent(studentId);
    }

}
