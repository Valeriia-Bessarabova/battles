package khnu.mizhfac.bessarabova.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    static final Logger log = LoggerFactory.getLogger(Game.class);
    public static boolean fight(Warrior first, Warrior second) {
        if(first instanceof Healer && second instanceof Healer){
            second.acceptDamage(10000);
            return true;
        } else {
            while (first.isAlive()) {
                first.hit(second);
                if (!second.isAlive()){
                    return true;
                }
                second.hit(first);
            }
            return false;
        }


    }
    public static boolean fight(Army first, Army second){
        log.info("Army {} fights against army {}", first, second);
        var it1 = first.firstAliveIterator();
        var it2 = second.firstAliveIterator();
        while (it1.hasNext() && it2.hasNext()){
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();
    }

    public static boolean straightFight(Army first, Army second){
        log.info("Army {} fights against army {}", first, second);

        while (!first.isEmpty() && !second.isEmpty()){
            var it1 = first.iterator();
            var it2 = second.iterator();
            while (it1.hasNext() && it2.hasNext()){
                fight(it1.next(), it2.next());
            }
        }
        return !first.isEmpty();
    }
}
