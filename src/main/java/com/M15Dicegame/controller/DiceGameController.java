package com.M15Dicegame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.M15Dicegame.dto.Game;
import com.M15Dicegame.dto.User;
import com.M15Dicegame.service.UserServiceImpl;

@RestController
@RequestMapping("/")
public class DiceGameController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	@PostMapping("/players")
	public User createNewUser(@RequestBody User user) {
		return userServiceImpl.addNewUser(user);
	}	
	
	 
	@PutMapping("/players")
	public User changeUserName(@RequestBody User userHttp) {
		User user = userServiceImpl.findById(userHttp.getId());
		user.setName(userHttp.getName());
		return userServiceImpl.updateUser(user);
	}
	
	
	
	@PostMapping("/players/{id}/games/")
	public Game throwDices(@PathVariable(name="id") Long id) {
		User user = userServiceImpl.findById(id);
		Game game = user.play();
		userServiceImpl.saveNewGame(game);
		userServiceImpl.updateUser(user);
		List<Game> gamesList = user.getGames(); 
		return gamesList.get(gamesList.size()-1);
		
	}
	
	
	@DeleteMapping("/players/{id}/games")
	public User deleteAllUserGames(@PathVariable(name="id") Long id) {
		User user = userServiceImpl.findById(id);
		user.deleteAllGames();
		userServiceImpl.updateUser(user);
		return user;
	}
	
	
	
	@GetMapping("/players/")
	public List<User> getAllUsersWithGameStatistics() {
		return userServiceImpl.getAllUsers();
	}
	
	
	@GetMapping("/players/{id}/games")
	public List<Game> getUserGames(@PathVariable(name="id") Long id) {
		User user = userServiceImpl.findById(id);
		return user.getGames();
	}
	

	
	@GetMapping("/players/ranking")
	public float getAverageGameWinningStatistic() {
		return userServiceImpl.getAverageWinningScore();
	}
	

	
	@GetMapping("/players/ranking/loser")
	public List<User> getUserWithLowestScore() {
		return userServiceImpl.getLastRanking();
	}	
	
	@GetMapping("/players")
	public List<User> getPlayers() {
		return userServiceImpl.getPlayers();
	}
	
	
	
	@GetMapping("/players/ranking/winner")
	public List<User> getUserWithHighestScore() {
		return userServiceImpl.getFirstRanking();
	}
	
}
