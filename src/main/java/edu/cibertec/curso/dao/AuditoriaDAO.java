
package edu.cibertec.curso.dao;

import edu.cibertec.curso.dao.entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="auditoria")
public interface AuditoriaDAO extends JpaRepository<AuditoriaEntity, Integer>{
    
}
