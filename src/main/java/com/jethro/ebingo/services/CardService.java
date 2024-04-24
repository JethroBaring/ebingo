package com.jethro.ebingo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jethro.ebingo.models.Card;
import com.jethro.ebingo.models.Game;
import com.jethro.ebingo.repositories.BallRepository;
import com.jethro.ebingo.repositories.CardRepository;
import com.jethro.ebingo.repositories.GameRepository;
import com.jethro.ebingo.utils.BingoChecker;
import com.jethro.ebingo.utils.RandomNumberGenerator;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    BallRepository ballRepository;
    public Card createNewCard(int bcode) {
        List<Integer> b = RandomNumberGenerator.generateRandomNumbers(1, 15);
        List<Integer> i = RandomNumberGenerator.generateRandomNumbers(16, 30);
        List<Integer> n = RandomNumberGenerator.generateRandomNumbers(31, 45);
        List<Integer> g = RandomNumberGenerator.generateRandomNumbers(46, 65);
        List<Integer> o = RandomNumberGenerator.generateRandomNumbers(61, 75);
        Game game = gameRepository.getReferenceById(bcode);

        if (game == null) {
            return null;
        }

        Card card = new Card(b, i, n, g, o, game);

        return cardRepository.save(card);
    }

    public int checkWin(int card_token) {
        Card card = cardRepository.getReferenceById(card_token);
        List<Integer> balls = ballRepository.findAllByGameId(card.getGame().getId());
        List<Integer> b = card.getB();
        List<Integer> i = card.getI();
        List<Integer> n = card.getN();
        List<Integer> g = card.getG();
        List<Integer> o = card.getO();

        List<List<Integer>> bingo = new ArrayList<>();
        bingo.add(b);
        bingo.add(i);
        bingo.add(n);
        bingo.add(g);
        bingo.add(o);

        List<List<Integer>> transposedBingo = new ArrayList<>();
        for (int col = 0; col < bingo.get(0).size(); col++) {
            List<Integer> newRow = new ArrayList<>();
            for (List<Integer> row : bingo) {
                newRow.add(row.get(col));
            }
            transposedBingo.add(newRow);
        }

        markDrawnBalls(transposedBingo, balls);

        return BingoChecker.checkForWin(transposedBingo);
    }

    private void markDrawnBalls(List<List<Integer>> bingo, List<Integer> drawnBalls) {
        for (List<Integer> row : bingo) {
            for (int i = 0; i < row.size(); i++) {
                if (drawnBalls.contains(row.get(i))) {
                    row.set(i, -1); // Mark the ball as drawn
                }
            }
        }
    }
}
