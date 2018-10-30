package pl.bookmaker.externalservice.demo.models.dto;

public class GameDto {

	private int id;
	private int competitionID;
	private String homeName;
	private String awayName;
	private String date;
	private String startTime;
	private String status;
	private String score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompetitionID() {
		return competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getAwayName() {
		return awayName;
	}

	public void setAwayName(String awayName) {
		this.awayName = awayName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public GameDto(int id, int competitionID, String homeName, String awayName, String date, String startTime, String status, String score) {
		this.id = id;
		this.competitionID = competitionID;
		this.homeName = homeName;
		this.awayName = awayName;
		this.date = date;
		this.startTime = startTime;
		this.status = status;
		this.score = score;
	}
}
