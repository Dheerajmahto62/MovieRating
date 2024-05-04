package com.Dhiru.watchlist.entity;



import com.Dhiru.watchlist.entity.validations.NotBlank;
import com.Dhiru.watchlist.entity.validations.Priority;
import com.Dhiru.watchlist.entity.validations.size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Enter")
	private String title;
	private float rating;
	
	@Priority
	private String priority;
	
	@size(max =50 , message = "Comment should be maximum")
	private String comment;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
