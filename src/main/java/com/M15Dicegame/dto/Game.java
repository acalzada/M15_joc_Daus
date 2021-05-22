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
	
	// Constructors
	
	protected Game() {
		
	}
	
	public Game(int dice1_val, int dice2_val) {
		this.dice1_Value = dice1_val;
		this.dice2_Value = dice2_val;
		
		// Game Winning Rule
		this.game_won = (this.dice1_Value + this.dice2_Value) == this.winningGameValue;
		
	}
	
	
}
