package com.Dhiru.watchlist.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Dhiru.watchlist.entity.Movies;
import com.Dhiru.watchlist.services.DatabaseService;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
//		System.out.println(id);
		String viewName = "watchlistItemForm";
		Map<String, Object> model =  new HashMap<>();
		
		if(id== null) {
			model.put("movie", new Movies());
		} else {
			model.put("movie", databaseService.getMoviesById(id));
		}
		
//		Movies dummyMovies = new Movies();
//		dummyMovies.setTitle("dummy");
//		dummyMovies.setRating(0);
//		dummyMovies.setPriority(0);
//		dummyMovies.setComment("john doe");
//		
//		modelMap.put("watchlistItem", dummyMovies);
		
//		modelMap.put("watchlistItem", new Movies());
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitwatchListForm(@Validated @ModelAttribute("watchlisItem") Movies movie , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		
		/*
		if(id==null) {
			create new Movie
		} else {
		update
		}
		*/
		
		Integer id = movie.getId();
		if(id==null) {
			databaseService.create(movie);
		} else {
			databaseService.update(movie , id);
		}
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movies> movielist = databaseService.getAllMovies();
		model.put("watchlistrows", movielist);
		model.put("noofmovies", movielist.size());
		
		return new ModelAndView(viewName,model) ;
	}

}
