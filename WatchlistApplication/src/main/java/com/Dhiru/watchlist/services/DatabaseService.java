package com.Dhiru.watchlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dhiru.watchlist.entity.Movies;
import com.Dhiru.watchlist.repositories.MoveRepo;

@Service
public class DatabaseService {
	
	@Autowired
	MoveRepo movieRepo;
	
	@Autowired
	RatingService ratingService;
	public void create(Movies movie) {
		
		String rating = ratingService.getMoviesRating(movie.getTitle());
		if(rating!= null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
		
	}
	
	public List<Movies> getAllMovies(){
		
	return movieRepo.findAll();
	}
	
	public Movies getMoviesById(Integer id) {
		return movieRepo.findById(id).get();
	}

	public void update(Movies movie, Integer id) {
		// TODO Auto-generated method stub
		
		Movies toBeUpdateMovies = getMoviesById(id);
		toBeUpdateMovies.setTitle(movie.getTitle());
		toBeUpdateMovies.setRating(movie.getRating());
		toBeUpdateMovies.setPriority(movie.getPriority());
		toBeUpdateMovies.setComment(movie.getComment());
		
		movieRepo.save(toBeUpdateMovies);
	}
}
