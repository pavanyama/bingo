package com.bingo.service;

import com.bingo.evaluators.IEvaluator;
import com.bingo.evaluators.impl.EarlyCountEvaluator;
import com.bingo.evaluators.impl.FullHouseEvaluator;
import com.bingo.evaluators.impl.TopLineEvaluator;
import com.bingo.model.Game;

import java.util.ArrayList;
import java.util.List;

public class EvaluationService {

    List<IEvaluator> evaluators = new ArrayList<>();

    //If we dont want to register here, we can write custom annoation and annotation processor.
    public EvaluationService() {
        evaluators.add(new EarlyCountEvaluator());
        evaluators.add(new TopLineEvaluator());
        evaluators.add(new FullHouseEvaluator());
        //Any new evaluators comes add here.
    }


    public boolean evaluate(Game game) {
        evaluators.forEach(evaluator -> {
            if(!evaluator.isEvaluationIdentifiedWinner()){
                evaluator.evaluate(game);
            }
        });
        return true;
    }

}
