
package edu.cibertec.curso.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cibertec.curso.dao.entity.CursoEntity;

@Repository
public interface CursoDAO extends JpaRepository<CursoEntity,Integer>{

}
