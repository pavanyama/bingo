package com.bingo.service;

import com.bingo.evaluators.IEvaluator;
import com.bingo.evaluators.impl.EarlyCountEvaluator;
import com.bingo.evaluators.impl.FullHouseEvaluator;
import com.bingo.evaluators.impl.TopLineEvaluator;
import com.bingo.model.Game;

import java.util.ArrayList;
import java.util.List;

public class EvaluationService {

    private final List<IEvaluator> evaluators = new ArrayList<>();

    //If we don't want to register here, we can write custom annotation and annotation processor.
    public EvaluationService() {
        evaluators.add(new EarlyCountEvaluator());
        evaluators.add(new TopLineEvaluator());
        evaluators.add(new FullHouseEvaluator());
        //Any new evaluators comes add here.
    }

    public void evaluate(Game game) {
        evaluators.forEach(evaluator -> {
            if(evaluator.isEvaluationIdentifiedWinner()){
                evaluator.evaluate(game);
            }
        });
    }
    /* This will loop through all the evaluators and returns false
     even if one evaluator has not identified winner.*/
    public boolean isEveryEvaluationIdentifiedWinner() {
        return evaluators.stream().noneMatch(IEvaluator::isEvaluationIdentifiedWinner);
    }
}
