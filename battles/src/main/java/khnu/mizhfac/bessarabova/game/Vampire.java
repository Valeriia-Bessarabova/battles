package khnu.mizhfac.bessarabova.game;

import khnu.mizhfac.bessarabova.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vampire extends AbstractWarrior implements CanHitAndReportMixin {
    static final Logger log = LoggerFactory.getLogger(Main.class);
    static final int INITIAL_HEALTH = 40;
    static final int ATTACK = 4;
    static final int VAMPIRISM = 50;

    public Vampire() {
        super(INITIAL_HEALTH);
    }
    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(CanAcceptDamage opponent){
        int damageDealt = hitAndReportDealtDamage(opponent);
        int healthing = damageDealt*getVampirism()/100;
        setHealth(getHealth() + healthing);
    }
}
