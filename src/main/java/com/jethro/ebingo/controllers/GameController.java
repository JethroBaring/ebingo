package com.jethro.ebingo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jethro.ebingo.services.GameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GameController {
    @Autowired
    GameService service;

    @PostMapping("/newgame")
    public Map<String, Integer> createNewGame() {
        Map<String, Integer> game = new HashMap<>();
        game.put("bcode", service.createNewGame());

        return game;
    }

    @PostMapping("/nextball")
    public Object drawNextBall(@RequestParam int bcode) {
        Map<String, Integer> ball = new HashMap<>();
        ball.put("new_ball", service.drawNextBall(bcode));
        return ball;
    }

    @GetMapping("/drawnballs")
    public Map<String,List<Integer>> getDrawnBalls(@RequestParam int bcode) {
        return service.getDrawnBalls(bcode);
    }

}
