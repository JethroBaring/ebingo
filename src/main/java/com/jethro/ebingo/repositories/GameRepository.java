package com.jethro.ebingo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jethro.ebingo.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
