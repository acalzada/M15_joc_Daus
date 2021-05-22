package com.M15Dicegame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.M15Dicegame.dto.User;

public interface UserDAO extends JpaRepository<User, Long> {
	
	//@Query(value = "SELECT meanScore FROM User WHERE meanScore = (SELECT min(meanScore) FROM User)")
	@Query(value = "SELECT min(meanScore) FROM User")
	public float getMinMeanScore();
	
	public List<User> findByMeanScore(float meanScore);

}
