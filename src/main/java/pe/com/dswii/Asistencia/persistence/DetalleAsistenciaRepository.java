package pe.com.dswii.Asistencia.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.dswii.Asistencia.domain.dto.AttendanceDetailDTO;
import pe.com.dswii.Asistencia.domain.repository.AttendanceDetailRepository;
import pe.com.dswii.Asistencia.persistence.mapper.AttendanceDetailMapper;
import java.util.ArrayList;

import java.util.List;

@Repository
@AllArgsConstructor
public class DetalleAsistenciaRepository implements AttendanceDetailRepository {

    private final AttendanceDetailMapper mapper;
    EntityManager entityManager = null;
    public List<AttendanceDetailDTO> getDetailsForStudent(int studentId) {
        Query query = entityManager.createNativeQuery(
                        "SELECT c.id_curso, c.nombre_curso, " +
                                "count(CASE WHEN da.falta = 0 THEN 1 END) as get_attended, " +
                                "count(CASE WHEN da.falta = 1 THEN 1 END) as get_missing " +
                                "FROM tb_detalleasistencia as da " +
                                "JOIN tb_asistencia as a ON da.id_asistencia = a.id " +
                                "JOIN tb_persona as p ON p.id_persona = da.id_alumno " +
                                "JOIN tb_horario as h ON a.id_horario = h.id " +
                                "JOIN tb_curso as c ON c.id_curso = h.id_curso " +
                                "WHERE da.id_alumno = :studentId " +
                                "GROUP BY c.id_curso", Object[].class)
                .setParameter("studentId", studentId);

        List<Object[]> results = query.getResultList();
        List<AttendanceDetailDTO> attendanceDetails = new ArrayList<>();

        for (Object[] result : results) {
            AttendanceDetailDTO detailDTO = new AttendanceDetailDTO();
            detailDTO.setCourseId((int) result[0]);
            detailDTO.setCourseName((String) result[1]);
            detailDTO.setAttended(((Number) result[2]).intValue()); // Convertir a entero
            detailDTO.setMissing(((Number) result[3]).intValue()); // Convertir a entero
            attendanceDetails.add(detailDTO);
        }

        return attendanceDetails;
    }
    @Override
    public List<AttendanceDetailDTO> findDetailsForStudent(int studentId) {
        return getDetailsForStudent(studentId);
    }

}
