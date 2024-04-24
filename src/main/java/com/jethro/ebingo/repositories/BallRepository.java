package com.jethro.ebingo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jethro.ebingo.models.Ball;

public interface BallRepository extends JpaRepository<Ball, Integer>{
    @Query("SELECT b.number FROM Ball b WHERE b.game.id = :gameId")
    List<Integer> findAllByGameId(@Param("gameId") int gameId);
}
