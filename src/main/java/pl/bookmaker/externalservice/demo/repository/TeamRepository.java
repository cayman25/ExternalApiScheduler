package pl.bookmaker.externalservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.externalservice.demo.models.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
}
