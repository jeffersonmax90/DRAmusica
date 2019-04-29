package ual.dra.rest;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface CancionRepository extends CrudRepository<Cancion, Long> {
	
	
	@Query(value = "SELECT * from Canciones where titulo = :titulo ", nativeQuery=true)
	public List<Cancion> findPosicion(@Param("titulo") String titulo);
	
	
}