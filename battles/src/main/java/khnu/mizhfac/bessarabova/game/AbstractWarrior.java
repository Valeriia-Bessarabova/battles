package khnu.mizhfac.bessarabova.game;

import khnu.mizhfac.bessarabova.Main;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public abstract class AbstractWarrior implements Warrior {
    private static int idCounter = 0;
    static final Logger log = LoggerFactory.getLogger(AbstractWarrior.class);
    private int health;
    private int initialHealth;
    private int id = ++idCounter;
    public AbstractWarrior(int health){
        this.health = health;
        this.initialHealth = health;
    }

    public void acceptDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public abstract int getAttack();
    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    public String toString() {
        String name = getClass().getSimpleName();
        name = name.replaceAll("Impl", "");
        name = name.toUpperCase();
        return name + "#" + id + "{" +
                "h=" + health  +
                "}";
    }
}
