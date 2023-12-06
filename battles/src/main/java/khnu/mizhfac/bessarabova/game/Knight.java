package khnu.mizhfac.bessarabova.game;

public class Knight extends AbstractWarrior{
    static final int INITIAL_HEALTH = 50;
    static final int ATTACK = 7;
    public Knight(){
        super(INITIAL_HEALTH);
    }
    public Knight(int health) {
        super(health);
    }
    @Override
    public int getAttack() {
        return ATTACK;
    }
}
