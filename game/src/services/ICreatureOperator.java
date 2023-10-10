package services;

import entities.Creature;
import exceptions.GameException;

public interface ICreatureOperator {

    void attack(Creature attacking, Creature defending) throws NullPointerException, GameException;
}
