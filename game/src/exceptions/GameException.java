package exceptions;

public class GameException extends Exception{

    private GameException(String message){
        super(message);
    }

    public static GameException InvalidAttackParamException(int value) {
        return new GameException(String.format("%d is incorrect attack parameter: attack must be an integer between 0 and 30", value));
    }

    public static GameException InvalidDefenseParamException(int value) {
        return new GameException(String.format("%d is incorrect defense parameter: defense must be an integer between 0 and 30", value));
    }

    public static GameException InvalidMaxHealthParamException() {
        return new GameException("Max health must be positive");
    }

    public static GameException InvalidLowerDamageBorderParamException() {
        return new GameException("Lower damage border can't be negative");
    }

    public static GameException InvalidHigherDamageBorderParamException() {
        return new GameException("Higher damage border can't be negative or less than lower damage border");
    }

    public static GameException InvalidCreatureNameException() {
        return new GameException("Name should start with capital letter and contain letters only");
    }

    public static GameException MaxHealImpossibleException() {
        return new GameException("Heal impossible: player has max health already");
    }

    public static GameException HealingLimitReachedException() {
        return new GameException("You can heal only 4 times");
    }

    public static GameException InvalidDicesAmountException() {
        return new GameException("At least one dice must be rolled");
    }
}
