package com.bingo.evaluators.impl;

import com.bingo.evaluators.IEvaluator;

public abstract class AbstractEvaluator implements IEvaluator {

    private boolean isEvaluationIdentifiedWinner = false;

    @Override
    public boolean isEvaluationIdentifiedWinner() {
        return !this.isEvaluationIdentifiedWinner;
    }

    public void setEvaluationIdentifiedWinner(boolean evaluationIdentifiedWinner) {
        this.isEvaluationIdentifiedWinner = evaluationIdentifiedWinner;
    }
}
