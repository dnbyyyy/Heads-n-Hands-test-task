package tests;

import entities.Monster;
import entities.Player;
import exceptions.GameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.CreatureOperator;

public class GameTests {
    Player player;
    Monster monster;
    CreatureOperator operator;

    @BeforeEach
    public void Setup() throws GameException {
        player = new Player(
                "Den",
                100,
                30,
                20,
                20,
                30
        );

        monster = new Monster(
                "Domovoi",
                20,
                10,
                5,
                5,
                10
        );

        operator = new CreatureOperator();
    }

    @Test
    public void MonsterTakesDamage() {
        monster.takeDamage(12);
        Assertions.assertEquals(8, monster.getHealth());
    }

    @Test
    public void PlayerTakesDamageAndHeals() throws GameException {
        player.takeDamage(50);
        Assertions.assertEquals(50, player.getHealth());

        player.heal();
        Assertions.assertEquals(80, player.getHealth());
    }

    @Test
    public void PlayerReachesHealthLimit() throws GameException {
        for (int i = 0; i < 4; i++) {
            player.takeDamage(30);
            player.heal();
        }
        player.takeDamage(30);
        Assertions.assertThrows(GameException.class, () -> player.heal());
    }

    @Test
    public void MonsterFightPLayer() throws GameException {
        for (int i = 0; i < 10; i++) {
            operator.attack(monster, player);
        }
        Assertions.assertNotEquals(player.getMaxHealth(), player.getHealth());
    }

    @Test
    public void PlayerKillsMonster() throws GameException {
        for (int i = 0; i < 1000; i++) {
            operator.attack(player, monster);
        }

        Assertions.assertFalse(monster.isAlive());
    }
}
