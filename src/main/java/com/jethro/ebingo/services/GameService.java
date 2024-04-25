package com.jethro.ebingo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jethro.ebingo.models.Ball;
import com.jethro.ebingo.models.Game;
import com.jethro.ebingo.repositories.BallRepository;
import com.jethro.ebingo.repositories.GameRepository;
import com.jethro.ebingo.utils.RandomNumberGenerator;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    BallRepository ballRepository;

    public int createNewGame() {
        Game game = new Game();
        Game savedGame = gameRepository.save(game);
        return savedGame.getId();
    }

    public int drawNextBall(int bcode) {
        List<Integer> balls = ballRepository.findAllByGameId(bcode);
        int randomNumber = RandomNumberGenerator.generateRandomNumber(1, 75);
        while (balls.contains(randomNumber)) {
            randomNumber = RandomNumberGenerator.generateRandomNumber(1, 75);
        }

        Game game = gameRepository.getReferenceById(bcode);
        Ball ball = new Ball(randomNumber, game);

        return ballRepository.save(ball).getNumber();
    }

    public Map<String, List<Integer>> getDrawnBalls(int bcode) {
        Map<String, List<Integer>> drawn = new HashMap<>();
        List<Integer> drawnBalls = ballRepository.findAllByGameId(bcode);
        List<Integer> b = new ArrayList<>();
        List<Integer> i = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        List<Integer> g = new ArrayList<>();
        List<Integer> o = new ArrayList<>();

        for (int number : drawnBalls) {
            if (number >= 1 && number <= 15) {
                b.add(number);
            } else if (number >= 16 && number <= 30) {
                i.add(number);
            } else if (number >= 31 && number <= 45) {
                n.add(number);
            } else if (number >= 46 && number <= 60) {
                g.add(number);
            } else if (number >= 61 && number <= 75) {
                o.add(number);
            }
        }

        drawn.put("B", b);
        drawn.put("I", i);
        drawn.put("N", n);
        drawn.put("G", g);
        drawn.put("O", o);

        return drawn;
    }
}
