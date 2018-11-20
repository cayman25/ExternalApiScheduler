
package pl.bookmaker.externalservice.demo.models.externalApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "winner",
    "duration",
    "fullTime",
    "halfTime",
    "extraTime",
    "penalties"
})
public class Score {

    @JsonProperty("winner")
    private String winner;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("fullTime")
    private FullTime fullTime;
    @JsonProperty("halfTime")
    private HalfTime halfTime;
    @JsonProperty("extraTime")
    private ExtraTime extraTime;
    @JsonProperty("penalties")
    private Penalties penalties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    @Override
	public String toString() {
		return "Score [winner=" + winner + ", duration=" + duration + ", fullTime=" + fullTime + ", halfTime="
				+ halfTime + ", extraTime=" + extraTime + ", penalties=" + penalties + ", additionalProperties="
				+ additionalProperties + "]";
	}

	@JsonProperty("winner")
    public String getWinner() {
        return winner;
    }

    @JsonProperty("winner")
    public void setWinner(String winner) {
        this.winner = winner;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("fullTime")
    public FullTime getFullTime() {
        return fullTime;
    }

    @JsonProperty("fullTime")
    public void setFullTime(FullTime fullTime) {
        this.fullTime = fullTime;
    }

    @JsonProperty("halfTime")
    public HalfTime getHalfTime() {
        return halfTime;
    }

    @JsonProperty("halfTime")
    public void setHalfTime(HalfTime halfTime) {
        this.halfTime = halfTime;
    }

    @JsonProperty("extraTime")
    public ExtraTime getExtraTime() {
        return extraTime;
    }

    @JsonProperty("extraTime")
    public void setExtraTime(ExtraTime extraTime) {
        this.extraTime = extraTime;
    }

    @JsonProperty("penalties")
    public Penalties getPenalties() {
        return penalties;
    }

    @JsonProperty("penalties")
    public void setPenalties(Penalties penalties) {
        this.penalties = penalties;
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
