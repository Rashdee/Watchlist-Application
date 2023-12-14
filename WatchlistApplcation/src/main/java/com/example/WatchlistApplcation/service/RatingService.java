package com.example.WatchlistApplcation.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
    String apiUrl="https://www.omdbapi.com/?apikey=558ecaa8&t=";
    public String getMovieRating(String title){
        try{
            //fetch the rating by calling api
            RestTemplate template=new RestTemplate();

            ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl+title,ObjectNode.class);

            ObjectNode jsonObject= response.getBody();

            return jsonObject.path("imdbRating").asText();
        }catch(Exception e){
            System.out.println("Either movie name not availale or api is down"+e.getMessage());
            return null;

        }
    }
}
