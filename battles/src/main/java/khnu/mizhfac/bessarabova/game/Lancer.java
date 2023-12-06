package khnu.mizhfac.bessarabova.game;

public class Lancer extends AbstractWarrior implements CanHitAndReportMixin{
    static final int ATTACK = 6;
    static final int INITIAL_HEALTH = 50;
    static final int PENETRATION = 50;

    public Lancer() { super(INITIAL_HEALTH);}
    public int getAttack(){ return ATTACK;}
    @Override
    public void hit(CanAcceptDamage opponent) {
        int damageDealt = hitAndReportDealtDamage(opponent);
        if (opponent instanceof WarriorInArmy warriorInArmy){
            var nextBehind = warriorInArmy.getWarriorBehind();
            if (nextBehind.isPresent()) {
                int secondDamage = damageDealt * PENETRATION / 100;
                CanHit proxySecondHitByLancer = () -> secondDamage;
                proxySecondHitByLancer.hit(nextBehind.get());
            }
        }

    }
}
