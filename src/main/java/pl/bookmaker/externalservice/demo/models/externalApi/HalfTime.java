
package pl.bookmaker.externalservice.demo.models.externalApi;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "homeTeam",
    "awayTeam"
})
public class HalfTime {

    @JsonProperty("homeTeam")
    private Integer homeTeam;
    @JsonProperty("awayTeam")
    private Integer awayTeam;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("homeTeam")
    public Integer getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("homeTeam")
    public void setHomeTeam(Integer homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("awayTeam")
    public Integer getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("awayTeam")
    public void setAwayTeam(Integer awayTeam) {
        this.awayTeam = awayTeam;
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
