package com.M15Dicegame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.M15Dicegame.dto.User;

public interface UserDAO extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT new User(id, name, meanScore) FROM User")
	public List<User> getAllUsersIdAndNameAndMeanScore();
	
	@Query(value = "SELECT avg(meanScore) FROM User")
	public float getAverageMeanScore();
	
	@Query(value = "SELECT min(meanScore) FROM User")
	public float getMinMeanScore();
	
	@Query(value = "SELECT max(meanScore) FROM User")
	public float getMaxMeanScore();
	
	public List<User> findByMeanScore(float meanScore);

}
