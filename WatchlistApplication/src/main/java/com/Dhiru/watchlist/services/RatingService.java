package com.Dhiru.watchlist.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	
	String apiUrl = "http://www.omdbapi.com/?apikey=a8431cee&t=";
	
	public String getMoviesRating(String title) {
		// TODO Auto-generated method stub
		try {
			// try to fetch the rating by calling omdb api
			RestTemplate template = new RestTemplate();
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title , ObjectNode.class);
			
			ObjectNode jsonObjectNode = response.getBody();
			System.out.println(jsonObjectNode.path("imdbRating").asText());
			return jsonObjectNode.path("imdbRating").asText();
		} catch (Exception e) {
			// User entered rating will be taken
			
			System.out.println("Either movie name not available or api is down" + e.getMessage());
			return null;
		}

	}
}
