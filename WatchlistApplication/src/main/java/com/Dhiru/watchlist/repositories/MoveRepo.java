package com.Dhiru.watchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dhiru.watchlist.entity.Movies;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepo extends JpaRepository<Movies, Integer>{

}
