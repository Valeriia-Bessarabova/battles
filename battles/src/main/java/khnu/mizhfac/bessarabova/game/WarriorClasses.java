package khnu.mizhfac.bessarabova.game;

public enum WarriorClasses {
    WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER, HEALER, BERSERK;
    public static Warrior factory (WarriorClasses warriorClasses){
        return switch (warriorClasses){
            case WARRIOR -> new WarriorImpl();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
            case BERSERK -> new Berserk();
        };
    }
    public Warrior make(){
        return factory(this);
    }


}
