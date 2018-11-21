
package pl.bookmaker.externalscheduler.demo.models.externalApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "filters",
    "competition",
    "matches"
})
public class MatchesExternalApi {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("filters")
    private Filters filters;
    @JsonProperty("competition")
    private Competition competition;
    @JsonProperty("matches")
    private List<Matches> matches = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
	public String toString() {
		return "MatchesExternalApi [count=" + count + ", filters=" + filters + ", competition=" + competition
				+ ", matches=" + matches + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("filters")
    public Filters getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    @JsonProperty("competition")
    public Competition getCompetition() {
        return competition;
    }

    @JsonProperty("competition")
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @JsonProperty("matches")
    public List<Matches> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<Matches> matches) {
        this.matches = matches;
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
