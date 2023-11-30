package pe.com.dswii.Asistencia.domain.repository;

import org.springframework.data.repository.query.Param;
import pe.com.dswii.Asistencia.domain.AttendanceDetail;
import pe.com.dswii.Asistencia.domain.dto.AttendanceDetailDTO;

import java.util.List;

public interface AttendanceDetailRepository {
    List<AttendanceDetailDTO> findDetailsForStudent(@Param("studentId") int studentId);
}
