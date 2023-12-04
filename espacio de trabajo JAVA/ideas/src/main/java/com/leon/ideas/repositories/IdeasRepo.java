package com.leon.ideas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.ideas.models.IdeasModel;

@Repository
public interface IdeasRepo extends CrudRepository <IdeasModel,Long> {

    //Este método recupera todos las ideas de la base de datos
    List<IdeasModel> findAll(); 
    
    
	//CONSULTA PARA OBTENER IDEAS ORDENADAS POR LA CANTIDAD DE LIKES DE FORMA DESCENDENTE
    @Query(value = "SELECT i.* FROM ideas i LEFT JOIN likes l ON i.id = l.idea_id GROUP BY i.id, i.idea ORDER BY COUNT(l.user_id) DESC", nativeQuery = true)
    List<IdeasModel> findIdeasOrderByLikesDesc();
    
    //CONSULTA PARA OBTENES IDEAS ORDENADAS POR LA CANTIDAD DE LIKES DE FORMA ASCENDENTE
    @Query(value = "SELECT i.* FROM ideas i LEFT JOIN likes l ON i.id = l.idea_id GROUP BY i.id, i.idea ORDER BY COUNT(l.user_id) ASC", nativeQuery = true)
    List<IdeasModel> findIdeasOrderByLikesAsc();



}
