package entities;

import exceptions.GameException;

public class Monster extends Creature{

    public Monster(String name, int maxHealth, int attack, int defense, int lowerDamageBorder, int higherDamageBorder) throws GameException {
        super(name, maxHealth, attack, defense, lowerDamageBorder, higherDamageBorder);
    }
}
