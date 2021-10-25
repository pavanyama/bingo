package com.bingo.evaluators;

import com.bingo.model.Game;

public interface IEvaluator {
    boolean evaluate(Game game);
    boolean isEvaluationIdentifiedWinner();
    String getName();
}
