package pe.com.dswii.Asistencia.domain.repository;

import pe.com.dswii.Asistencia.domain.Type;
import java.util.List;
import java.util.Optional;

public interface TypeRepository {
    List<Type> getAll();
    Optional<Type> getType(int typeId);
    Type save (Type type);
    void delete(int typeId);
}
