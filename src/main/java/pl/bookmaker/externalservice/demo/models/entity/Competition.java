package pl.bookmaker.externalservice.demo.models.entity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
