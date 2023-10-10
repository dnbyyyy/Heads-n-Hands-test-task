package entities;

import exceptions.GameException;

public abstract class Creature {
    private final String name;
    private int health;
    private final int attack;
    private final int defense;
    private final int lowerDamageBorder;
    private final int higherDamageBorder;
    private boolean isAlive;

    private final String nameRegex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";


    public Creature(String name, int maxHealth, int attack, int defense, int lowerDamageBorder, int higherDamageBorder) throws GameException {
        if (!name.matches(nameRegex)) throw GameException.InvalidCreatureNameException();
        if (attack > 30 || attack < 0) throw GameException.InvalidAttackParamException(attack);
        if (defense > 30 || defense < 0) throw GameException.InvalidDefenseParamException(defense);
        if (maxHealth <= 0) throw GameException.InvalidMaxHealthParamException();
        if (lowerDamageBorder < 0) throw GameException.InvalidLowerDamageBorderParamException();
        if (higherDamageBorder < 0 || higherDamageBorder < lowerDamageBorder) throw GameException.InvalidHigherDamageBorderParamException();

        this.name = name;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.lowerDamageBorder = lowerDamageBorder;
        this.higherDamageBorder = higherDamageBorder;
        isAlive = true;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getLowerDamageBorder() {
        return lowerDamageBorder;
    }

    public int getHigherDamageBorder() {
        return higherDamageBorder;
    }

    public void takeDamage(int damageTaken) {
        int currentHealth = this.health - damageTaken;
        if (currentHealth <= 0) {
            isAlive = false;
            System.out.printf("%s died%n", name);
        }
        else {
            this.health = currentHealth;
            System.out.printf("Damage taken. Current health: %d%n", currentHealth);
        }
    }
}