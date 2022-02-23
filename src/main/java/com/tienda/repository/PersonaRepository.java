/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.repository;
import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
}
