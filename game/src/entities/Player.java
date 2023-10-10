package entities;

import exceptions.GameException;

public class Player extends Creature {

    private int healsCnt;
    public Player(String name, int maxHealth, int attack, int defense, int lowerDamageBorder, int higherDamageBorder) throws GameException {
        super(name, maxHealth, attack, defense, lowerDamageBorder, higherDamageBorder);
        healsCnt = 0;
    }

    public void heal() throws GameException {
        if (this.currentHealth == this.maxHealth) throw GameException.MaxHealImpossibleException();
        if (this.healsCnt == 4) throw GameException.HealingLimitReachedException();

        this.healsCnt++;
        int healPoints = this.maxHealth / 100 * 30;
        this.currentHealth = Math.min(this.currentHealth + healPoints, maxHealth);

        System.out.printf("Player %s healed. Current health: %d%n", this.name, this.currentHealth);
    }

}
