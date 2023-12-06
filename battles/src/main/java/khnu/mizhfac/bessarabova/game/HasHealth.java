package khnu.mizhfac.bessarabova.game;

public interface HasHealth {
    int getHealth();
    default boolean isAlive() {
        return getHealth() > 0;
    }

}
