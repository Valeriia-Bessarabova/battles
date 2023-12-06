package khnu.mizhfac.bessarabova.game;

public interface CanHitAndReportMixin extends CanHit{
    default int hitAndReportDealtDamage(CanAcceptDamage opponent){
        int secondStartHealth = opponent.getHealth();
        CanHit.super.hit(opponent);
        int secondEndHealth = opponent.getHealth();
        int damageDealt = secondStartHealth - secondEndHealth;
        return damageDealt;
    }
}
