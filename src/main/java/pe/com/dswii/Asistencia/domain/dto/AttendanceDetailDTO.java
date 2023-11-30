package pe.com.dswii.Asistencia.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDetailDTO {
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "attended")
    private int attended;
    @Column(name = "missing")
    private int missing;
}
