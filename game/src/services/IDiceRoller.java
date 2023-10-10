package services;

import exceptions.GameException;

public interface IDiceRoller {
    boolean rollDicesToAttack(int dicesAmount) throws GameException;
}

