package com.spring.puebla.repository;

import com.spring.puebla.model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol, Integer>{
    
    
    @Query("SELECT o FROM Rol o WHERE o.estadorol != 0")
    public Iterable<Rol> listAllActivos(); 
}
