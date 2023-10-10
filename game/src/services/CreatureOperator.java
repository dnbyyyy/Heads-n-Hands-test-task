package services;

import entities.Creature;
import exceptions.GameException;

import java.util.concurrent.ThreadLocalRandom;

public class CreatureOperator implements ICreatureOperator {

    private final DiceRoller diceRoller = new DiceRoller();
    @Override
    public void attack(Creature attacking, Creature defending) throws NullPointerException, GameException {
        if (attacking == null || defending == null) throw new NullPointerException();

        if (!defending.isAlive()) {
            System.out.printf("%s is already dead!%n", defending.getName());
            return;
        }

        int attackModifier = Math.abs(attacking.getAttack() - defending.getDefense()) + 1;

        boolean attackIsSuccessful = diceRoller.rollDicesToAttack(attackModifier);
        if (attackIsSuccessful) {
            int damagePoints = ThreadLocalRandom.current().nextInt(attacking.getLowerDamageBorder(), attacking.getHigherDamageBorder() + 1);
            defending.takeDamage(damagePoints);

            System.out.printf("Attack successful! %s now has %d health points%n", defending.getName(), defending.getHealth());
        }
        else System.out.println("Attack unsuccessful");
    }
}
