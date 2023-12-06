package khnu.mizhfac.bessarabova.game;

import khnu.mizhfac.bessarabova.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Berserk extends AbstractWarrior implements CanHitAndReportMixin{
    static final Logger log = LoggerFactory.getLogger(Main.class);
    static final int INITIAL_HEALTH = 60;
    static final int ATTACK = 4;
    static final int BERSERK_ATTACK = 2;

    public Berserk() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        if(getHealth()<INITIAL_HEALTH/2){
            log.info("Warrior {} hits {}", this, opponent);
            opponent.acceptDamage(getAttack() + BERSERK_ATTACK);
        } else {
            super.hit(opponent);
        }
    }


}
