
package pl.bookmaker.externalscheduler.demo.models.externalApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "season",
    "utcDate",
    "status",
    "matchday",
    "stage",
    "group",
    "lastUpdated",
    "homeTeam",
    "awayTeam",
    "score",
    "referees"
})
public class Matches {

    @Override
	public String toString() {
		return "Match [id=" + id + ", season=" + season + ", utcDate=" + utcDate + ", status=" + status + ", matchday="
				+ matchday + ", stage=" + stage + ", group=" + group + ", lastUpdated=" + lastUpdated + ", homeTeam="
				+ homeTeam + ", awayTeam=" + awayTeam + ", score=" + score + ", referees=" + referees
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("id")
    private Integer id;
    @JsonProperty("season")
    private Season season;
    @JsonProperty("utcDate")
    private String utcDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("matchday")
    private Object matchday;
    @JsonProperty("stage")
    private String stage;
    @JsonProperty("group")
    private String group;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("homeTeam")
    private HomeTeam homeTeam;
    @JsonProperty("awayTeam")
    private AwayTeam awayTeam;
    @JsonProperty("score")
    private Score score;
    @JsonProperty("referees")
    private List<Referee> referees = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("season")
    public Season getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(Season season) {
        this.season = season;
    }

    @JsonProperty("utcDate")
    public String getUtcDate() {
        return utcDate;
    }

    @JsonProperty("utcDate")
    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("matchday")
    public Object getMatchday() {
        return matchday;
    }

    @JsonProperty("matchday")
    public void setMatchday(Object matchday) {
        this.matchday = matchday;
    }

    @JsonProperty("stage")
    public String getStage() {
        return stage;
    }

    @JsonProperty("stage")
    public void setStage(String stage) {
        this.stage = stage;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("homeTeam")
    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("homeTeam")
    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("awayTeam")
    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("awayTeam")
    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    @JsonProperty("score")
    public Score getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Score score) {
        this.score = score;
    }

    @JsonProperty("referees")
    public List<Referee> getReferees() {
        return referees;
    }

    @JsonProperty("referees")
    public void setReferees(List<Referee> referees) {
        this.referees = referees;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
