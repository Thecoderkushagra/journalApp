package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiToken;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public Weather getWeather(String city){
        String finalApi = appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", apiToken);
        ResponseEntity<Weather> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, Weather.class);
        return response.getBody();
    }

    // MAKING A POST REQUEST
    public Weather postCall(String city){
        String finalApi = appCache.APP_CACHE.get("weather_api").replace("CITY", city).replace("API_KEY", apiToken);

        String requestBody = "{name:vipul,password:vipul}";
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody);

        ResponseEntity<Weather> response = restTemplate.exchange(finalApi, HttpMethod.POST, httpEntity, Weather.class);
        return response.getBody();
    }

}
