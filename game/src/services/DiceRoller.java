package services;

import exceptions.GameException;

import java.util.concurrent.ThreadLocalRandom;

public class DiceRoller implements IDiceRoller {

    @Override
    public boolean rollDicesToAttack(int dicesAmount) throws GameException {
        if (dicesAmount < 1) throw GameException.InvalidDicesAmountException();
        for (int i = 0; i < dicesAmount; i++) {
            if (ThreadLocalRandom.current().nextInt(1, 7) > 4) return true;
        }
        return false;
    }
}
