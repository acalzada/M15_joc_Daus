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
	
	
	public User findById(Long id) {
		return userDAO.findById(id).get();
	}
	
	public List<User> getLastRanking() {
		float min_mean_score = userDAO.getMinMeanScore();
		return userDAO.findByMeanScore(min_mean_score);
	}
	
	public List<User> getPlayers() {
		return userDAO.findAll();
	}
	
}
