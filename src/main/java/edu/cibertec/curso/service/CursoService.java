
package edu.cibertec.curso.service;

import edu.cibertec.curso.dao.CursoDAO;
import java.util.List;
import edu.cibertec.curso.dao.entity.CursoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    CursoDAO cursoDao;
    
    public List<CursoEntity> listarTodos(){
        return cursoDao.findAll();
    }
    
    public CursoEntity obtenerUno(int codigo){
        return cursoDao.findById(codigo).get();
    }
    
    public void insertar(CursoEntity ce){
        cursoDao.save(ce);
    }
    
    public void modificar(CursoEntity ce){
        cursoDao.save(ce);
    }
    
    public void eliminar(int codigo){
        cursoDao.deleteById(codigo);
    }

}
