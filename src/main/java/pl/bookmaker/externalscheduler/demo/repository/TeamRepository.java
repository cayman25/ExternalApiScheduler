package pl.bookmaker.externalscheduler.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bookmaker.externalscheduler.demo.models.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
}
