package com.M15Dicegame.dto;

import javax.persistence.*;


@Entity
@Table(name="Game")
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="game_id")
	private Long id;
	
	@Column(nullable=false)
	private int dice1_Value;
	
	@Column(nullable=false)
	private int dice2_Value;
	
	@Column(nullable=false)
	private boolean game_won;
	
	@Transient
	int winningGameValue = 7;  // Value to get adding the two dices in order to win the game.
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Transient
	private User user;
	
	// Constructors
	
	protected Game() {
		
	}
	
	public Game(int dice1_val, int dice2_val) {
		this.dice1_Value = dice1_val;
		this.dice2_Value = dice2_val;
		
		// Game Winning Rule
		this.game_won = (this.dice1_Value + this.dice2_Value) == this.winningGameValue;
		
	}

	// GETTERS & SETTERS
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dice1_Value
	 */
	public int getDice1_Value() {
		return dice1_Value;
	}

	/**
	 * @param dice1_Value the dice1_Value to set
	 */
	public void setDice1_Value(int dice1_Value) {
		this.dice1_Value = dice1_Value;
	}

	/**
	 * @return the dice2_Value
	 */
	public int getDice2_Value() {
		return dice2_Value;
	}

	/**
	 * @param dice2_Value the dice2_Value to set
	 */
	public void setDice2_Value(int dice2_Value) {
		this.dice2_Value = dice2_Value;
	}

	/**
	 * @return the game_won
	 */
	public boolean isGame_won() {
		return game_won;
	}

	/**
	 * @param game_won the game_won to set
	 */
	public void setGame_won(boolean game_won) {
		this.game_won = game_won;
	}

	/**
	 * @return the winningGameValue
	 */
	public int getWinningGameValue() {
		return winningGameValue;
	}

	/**
	 * @param winningGameValue the winningGameValue to set
	 */
	public void setWinningGameValue(int winningGameValue) {
		this.winningGameValue = winningGameValue;
	}
	

	
	
	
}
