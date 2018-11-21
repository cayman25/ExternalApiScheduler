package pl.bookmaker.externalscheduler.demo.models.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Competition {

	@Id
	@NonNull
	private int competitionID;
	@NonNull
	private String competitionName;
	
	@OneToMany(mappedBy = "competition")
	private Set<Game> games = new HashSet<>();

}
