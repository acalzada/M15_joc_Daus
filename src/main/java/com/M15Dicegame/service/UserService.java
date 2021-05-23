package com.M15Dicegame.service;

import java.util.List;

import com.M15Dicegame.dto.*;

public interface UserService {
	
	public Game saveNewGame(Game game);
	
	public User findById(Long id);
	
	public List<User> getLastRanking();
		
	public void updateUser(User user);
}
