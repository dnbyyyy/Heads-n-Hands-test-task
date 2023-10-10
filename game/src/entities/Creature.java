package entities;

import exceptions.GameException;

public abstract class Creature {
    protected final String name;
    protected final int maxHealth;
    protected final int attack;
    protected final int defense;
    protected final int lowerDamageBorder;
    protected final int higherDamageBorder;
    protected int currentHealth;
    protected boolean isAlive;


    public Creature(String name, int maxHealth, int attack, int defense, int lowerDamageBorder, int higherDamageBorder) throws GameException {
        String nameRegex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        if (!name.matches(nameRegex)) throw GameException.InvalidCreatureNameException();
        if (attack > 30 || attack < 0) throw GameException.InvalidAttackParamException(attack);
        if (defense > 30 || defense < 0) throw GameException.InvalidDefenseParamException(defense);
        if (maxHealth <= 0) throw GameException.InvalidMaxHealthParamException();
        if (lowerDamageBorder < 0) throw GameException.InvalidLowerDamageBorderParamException();
        if (higherDamageBorder < 0 || higherDamageBorder < lowerDamageBorder) throw GameException.InvalidHigherDamageBorderParamException();

        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
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
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
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

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void takeDamage(int damageTaken) {
        int currentHealth = this.currentHealth - damageTaken;
        if (currentHealth <= 0) {
            isAlive = false;
            System.out.printf("%s is dead%n", name);
        }
        else {
            this.currentHealth = currentHealth;
            System.out.printf("Damage taken. Current health: %d%n", currentHealth);
        }
    }
}