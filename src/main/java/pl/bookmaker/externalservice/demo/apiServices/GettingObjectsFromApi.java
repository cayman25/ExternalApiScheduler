package pl.bookmaker.externalservice.demo.apiServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

//@PropertySource(value = {"classpath:application.properties"})
public class GettingObjectsFromApi {

/*    @Value("${api.apiAuthToken}")
    private String apiAuthToken;*/

    private String createUrlToGetJson(int leagueId, int dateTo) {
        String url = "http://api.football-data.org/v2/competitions/" + leagueId + "/matches?" +
                "dateFrom="	+ DateValidation.getTodayWithAddOrSubstract(0) + //0 means days to today
                "&dateTo=" + DateValidation.getTodayWithAddOrSubstract(10);
        return url;
    }

    public  MatchesExternalApi createMatchesExternalApi(int leagueId) {
            String url = createUrlToGetJson(leagueId,0);
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Auth-Token","bf5c0f84e2214a43978af5da8e98d878");
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setObjectMapper(new ObjectMapper());
            restTemplate.getMessageConverters().add(converter);
            ResponseEntity<MatchesExternalApi> list = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    MatchesExternalApi.class);
        return list.getBody();
    }

}

