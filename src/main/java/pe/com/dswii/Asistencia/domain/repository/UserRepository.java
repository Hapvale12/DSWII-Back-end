package pe.com.dswii.Asistencia.domain.repository;

import pe.com.dswii.Asistencia.domain.User;
import pe.com.dswii.Asistencia.web.dtosecurity.DtoAuthResponse;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    List<User> getAllActive();
    List<User> getAllInactive();
    Optional<User> getUser(int iduser);
    List<User> getListaByNombreusuario(String user);
    User getByUsername(String username);
    User save(User user);
    void delete(int iduser);
    boolean existsByUserUsuario(String username);
    boolean existsByIdpersona(int idpasajero);
    DtoAuthResponse login(String user, String password);
}
