package com.bingo.evaluators;

import com.bingo.model.Game;

public interface IEvaluator {
    void evaluate(Game game);
    boolean isEvaluationIdentifiedWinner();
    String getName();
}
