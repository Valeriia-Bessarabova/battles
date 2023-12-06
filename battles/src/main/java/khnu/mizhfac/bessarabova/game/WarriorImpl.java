package khnu.mizhfac.bessarabova.game;

public class WarriorImpl extends AbstractWarrior{
    static final int INITIAL_HEALTH = 50;
    static final int ATTACK= 5;

    public WarriorImpl() {
        this(INITIAL_HEALTH);
    }
    private WarriorImpl(int health) {
        super(health);
    }
    @Override
    public int getAttack() {
        return ATTACK;
    }


}
