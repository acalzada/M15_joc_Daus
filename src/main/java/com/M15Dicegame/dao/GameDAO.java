package com.M15Dicegame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.M15Dicegame.dto.Game;

public interface GameDAO extends JpaRepository<Game, Long> {

}
