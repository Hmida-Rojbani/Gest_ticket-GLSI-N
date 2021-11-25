package de.tekup.rst.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.rst.entities.MetEntity;

public interface MetRepository extends JpaRepository<MetEntity, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM met_entity where  id = ( "
	  		+ "Select mets_id as id from  compose where mets_id in ( "
	  		+ "SELECT id FROM met_entity where dtype = 'Plat' and  id in ( "
	  		+ "SELECT  "
	  		+ "    mets_id "
	  		+ "FROM "
	  		+ "    compose "
	  		+ "WHERE "
	  		+ "    tickets_numero IN (SELECT  "
	  		+ "            numero "
	  		+ "        FROM "
	  		+ "            ticket_entity "
	  		+ "        WHERE "
	  		+ "            date_time < :fin "
	  		+ "                AND date_time > :deb))) "
	  		+ "group by mets_id "
	  		+ "order by count(*) desc "
	  		+ "limit 1)")
	  MetEntity	platPlutAcheter(@Param("deb") LocalDate deb,@Param("fin")  LocalDate fin);
}
