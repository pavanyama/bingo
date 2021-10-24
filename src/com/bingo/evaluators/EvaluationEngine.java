package com.bingo.evaluators;

import com.bingo.evaluators.impl.EarlyFiveEvaluator;
import com.bingo.evaluators.impl.FullHouseEvaluator;
import com.bingo.evaluators.impl.TopLineEvaluator;

import java.util.ArrayList;
import java.util.List;

public class EvaluationEngine {

    List<IEvaluator> evaluators = new ArrayList<>();

    //If we dont want to register here, we can write custom annoation and annotation processor.
    public EvaluationEngine() {
        evaluators.add(new EarlyFiveEvaluator());
        evaluators.add(new TopLineEvaluator());
        evaluators.add(new FullHouseEvaluator());
        //Any new evaluators comes add here.
    }


    public boolean evaluate() {
        evaluators.forEach(evaluator -> evaluator.evaluate());
        return true;
    }

}
