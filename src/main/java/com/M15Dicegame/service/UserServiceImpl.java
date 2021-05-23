package com.M15Dicegame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.M15Dicegame.dao.*;
import com.M15Dicegame.dto.*;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	GameDAO gameDAO;
	
	public User addNewUser(User user) {
		return userDAO.save(user);
	}
	
	
	public User updateUser(User user) {
		return userDAO.save(user);
	}
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsersIdAndNameAndMeanScore();
	}
	
	public User findById(Long id) {
		return userDAO.findById(id).get();
	}
	
	public List<User> getLastRanking() {
		float min_mean_score = userDAO.getMinMeanScore();
		return userDAO.findByMeanScore(min_mean_score);
	}
	
	public List<User> getFirstRanking() {
		float max_mean_score = userDAO.getMaxMeanScore();
		return userDAO.findByMeanScore(max_mean_score);
	}
	
	public List<User> getPlayers() {
		return userDAO.findAll();
	}
	
	public float getAverageWinningScore() {
		return userDAO.getAverageMeanScore();
	}
	
}
