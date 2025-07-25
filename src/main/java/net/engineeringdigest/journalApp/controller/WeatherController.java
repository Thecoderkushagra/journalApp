package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.Weather;
import net.engineeringdigest.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<?> greeting(){
        Weather response = weatherService.getWeather("Mumbai");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    // WEATHER API DON'T SUPPORT ANY POST REQUESTS
    // IT IS JUST THE DEMONSTRATION OF HOW A POST CALL CAN BE MADE.
    @PostMapping
    public ResponseEntity<?> give(){
        Weather response = weatherService.postCall("Mumbai");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
