package pe.com.dswii.Asistencia.domain.repository;

import pe.com.dswii.Asistencia.domain.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository {
    List<UserType> getAll();
    List<UserType> getAllActive();
    List<UserType> getAllInactive();
    Optional<UserType> getUserType(int userTypeId);
    Optional<List<UserType>> getByUserTypeName(String name);
    UserType save(UserType userType);
    void delete(int userTypeId);
}
