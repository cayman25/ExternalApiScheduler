package pl.bookmaker.externalscheduler.demo.models.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "matchID")
public class Game {

	@Id
	private int matchID;

	@JoinColumn(name = "Competition")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Competition competition;
	private String dateMatch;
	private String startTime;
	private String statusMatch;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Team homeTeam;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Team awayTeam;
	private String winner;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	@ColumnDefault(value = "0")
	private boolean verifiedStatus;

	public Game(int matchID, Competition competition, String dateMatch, String startTime, String statusMatch, Team homeTeam, Team awayTeam, String winner) {
		this.matchID = matchID;
		this.competition = competition;
		this.dateMatch = dateMatch;
		this.startTime = startTime;
		this.statusMatch = statusMatch;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winner = winner;
	}

}

