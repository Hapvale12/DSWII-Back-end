package pe.com.dswii.Asistencia.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.dswii.Asistencia.persistence.entity.TipoUsuario;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioCrudRepository extends JpaRepository<TipoUsuario, Integer> {
    @Query(value = "SELECT * FROM tb_tipousuario WHERE activo_tipousuario = 'A'", nativeQuery = true)
    Optional<List<TipoUsuario>> findAllActive();
    @Query(value = "SELECT * FROM tb_tipousuario WHERE activo_tipousuario = 'I'", nativeQuery = true)
    Optional<List<TipoUsuario>> findAllInactive();
    @Query(value = "SELECT * FROM tb_tipousuario WHERE activo_tipousuario = 'A' AND nombre_tipousuario LIKE %:nombre%", nativeQuery = true)
    Optional<List<TipoUsuario>> findByNombreUsuarioTipo(@Param("nombre") String nombre);
}
