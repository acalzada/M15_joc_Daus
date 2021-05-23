package com.M15Dicegame.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(length=45, nullable=true, unique=true)
	private String name;
	
	@Column(nullable=false)
	private LocalDateTime registration_date;
	
	@Column(name="meanScore", nullable=false, unique=false)
	private float meanScore;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="user_id")
	private List <Game> games;
	
	
	// Constructors
	
	public User() {
	}
	
	
	public User(String name) {
		this.name = name;
	}

	public User(Long id, String name, float meanScore) {
		this.id = id;
		this.name = name;
		this.meanScore = meanScore;
	}
	
	// Getters & Setters
	

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Get the User's unique Id
	 * @return the User's id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Get USer's name
	 * @return the User's name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set the User's name
	 * @param name the name to assign to the user.
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Get the date the User registered into the system
	 * @return the registration_date
	 */
	public LocalDateTime getRegistration_date() {
		return registration_date;
	}


	/**
	 * Get all games a User has played and are registered in the system (not deleted previously).
	 * @return all the User's games
	 */
	public List<Game> getGames() {
		return games;
	}


	/**
	 * Delete ALL the games a user has registered in the system.
	 */
	public void deleteAllGames() {
		this.games.clear();
	}


	/**
	 * @return the meanScore
	 */
	public float getMeanScore() {
		return meanScore;
	}


	/**
	 * @param meanScore the meanScore to set
	 */
	public void setMeanScore(float meanScore) {
		this.meanScore = meanScore;
	}
	
	

	
}
