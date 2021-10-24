package com.bingo.model;

import com.bingo.evaluators.IEvaluator;

/*
 * This represents a winner on a particular winning combination.
 */
public class Winner extends PlayersTicket {
    IEvaluator evaluator;

    public Winner(Player player,
                  Ticket ticket,
                  IEvaluator evaluator) {
        super(player, ticket);
    }
}
