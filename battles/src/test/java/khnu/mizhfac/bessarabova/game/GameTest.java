package khnu.mizhfac.bessarabova.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static khnu.mizhfac.bessarabova.game.Game.fight;
import static khnu.mizhfac.bessarabova.game.Game.straightFight;
import static khnu.mizhfac.bessarabova.game.WarriorClasses.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {

    @ParameterizedTest
    @MethodSource("warriorsPairsFirstWin")
    @DisplayName("first should win")
    void fightTestsFirstWin(Warrior first, Warrior second) {
       assertTrue(fight(first, second));
    }

    @ParameterizedTest
    @MethodSource("warriorsPairsSecondWin")
    @DisplayName("second should win")
    void fightTestsSecondWin(Warrior first, Warrior second) {
        assertFalse(fight(first, second));
    }

    static Stream<Arguments> warriorsPairsFirstWin(){
        return Stream.of(
                arguments(KNIGHT.make(), WARRIOR.make()),
                arguments(WARRIOR.make(), WARRIOR.make()),
                arguments(KNIGHT.make(), KNIGHT.make()),
                arguments(DEFENDER.make(), WARRIOR.make()),
                arguments(DEFENDER.make(), VAMPIRE.make()),
                arguments(VAMPIRE.make(), WARRIOR.make())

        );
    }
    static Stream<Arguments> warriorsPairsSecondWin(){
        return Stream.of(
                arguments(WARRIOR.make(), KNIGHT.make()),
                arguments(VAMPIRE.make(), KNIGHT.make())
        );
    }

    @Test
    @DisplayName("WarriorVSDefender: D win V, D h=22, V h=-1")
    void WarriorVSDefender() {
        var defender = DEFENDER.make();
        var warrior = WARRIOR.make();

        boolean res = fight(warrior, defender);

        assertAll(
                () ->       assertFalse(res),
                () ->  assertEquals(9, ((AbstractWarrior) defender).getHealth()),
                () ->   assertEquals(-1, ((AbstractWarrior) warrior).getHealth())
        );

    }

    @Test
    @DisplayName("VampireVSDefender: D win V, D h=22, V h=-1")
    void VampireVSDefender() {
        var defender = DEFENDER.make();
        var vampire = VAMPIRE.make();

        boolean res = fight(defender, vampire);

        assertAll(
                () ->       assertTrue(res),
                () ->  assertEquals(22, ((AbstractWarrior) defender).getHealth()),
                () ->   assertEquals(-1, ((AbstractWarrior) vampire).getHealth())
        );

    }

    @Test
    @DisplayName("LancerVSWarrior")
    void LancerVSWarrior() {
        var lancer = LANCER.make();
        var warrior = WARRIOR.make();

        boolean res = fight(lancer, warrior);

        assertAll(
                () ->       assertTrue(res),
                () ->  assertEquals(10, ((AbstractWarrior) lancer).getHealth()),
                () ->   assertEquals(-4, ((AbstractWarrior) warrior).getHealth())
        );

    }

    @Test
    @DisplayName("WarriorVSVampire")
    void WarriorVSVampire() {
        var vampire = VAMPIRE.make();
        var warrior = WARRIOR.make();

        boolean res = fight(warrior, vampire);

        assertAll(
                () ->       assertTrue(res),
                () ->  assertEquals(-1, ((AbstractWarrior) vampire).getHealth()),
                () ->   assertEquals(2, ((AbstractWarrior) warrior).getHealth())
        );

    }

    @Test
    @DisplayName("HealerVSHealer: first should win")
    void HealerVSHealer() {
        var first = HEALER.make();
        var second = HEALER.make();

        boolean res = fight(first, second);

        assertAll(
                () ->       assertTrue(res),
                () ->  assertEquals(50, ((AbstractWarrior) first).getHealth()),
                () ->   assertEquals(-9950, ((AbstractWarrior) second).getHealth())
        );

    }

    @Test
    void lancerSmokeTest() {
       var chuck = WARRIOR.make();
       var bruce = WARRIOR.make();
       var carl = KNIGHT.make();
       var dave = WARRIOR.make();
       var mark = WARRIOR.make();
       var bob = DEFENDER.make();
       var mike = KNIGHT.make();
       var rog = WARRIOR.make();
       var lancelot = DEFENDER.make();
       var eric = VAMPIRE.make();
       var adam = VAMPIRE.make();
       var richard = DEFENDER.make();
       var ogre = WARRIOR.make();
       var freelancer = LANCER.make();
       var vampire = VAMPIRE.make();

       assertTrue(fight(chuck, bruce));
       assertFalse(fight(dave, carl));
       assertTrue(chuck.isAlive());
       assertFalse(bruce.isAlive());
       assertTrue(carl.isAlive());
       assertFalse(dave.isAlive());
       assertFalse(fight(carl, mark));
       assertFalse(carl.isAlive());
       assertFalse(fight(bob, mike));
       assertTrue(fight(lancelot, rog));
       assertFalse(fight(eric, richard));
       assertTrue(fight(ogre, adam));
       assertTrue(fight(freelancer, vampire));
       assertTrue(freelancer.isAlive());

       var my_army = new Army()
               .addUnits(DEFENDER, 2)
               .addUnits(VAMPIRE, 2)
               .addUnits(LANCER, 4)
               .addUnits(WARRIOR, 1);
        var enemy_army = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 2)
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 3);
        var army_3 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 1)
                .addUnits(DEFENDER, 2);
        var army_4 = new Army()
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 2);

        assertTrue(fight(my_army, enemy_army));
        assertFalse(fight(army_3, army_4));




    }

    @Test
    @DisplayName("3. Fight: when warrior fights against warrior he should be alive")
    void fight03() {
        Warrior bob = WARRIOR.make();
        Warrior mars = WARRIOR.make();

        fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight: when knight fights against warrior he should be alive")
    void fight04() {
        Warrior zeus = KNIGHT.make();
        Warrior godkiller = WARRIOR.make();

        fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight: when knight fights against warrior second shouldn't be alive")
    void fight05() {
        Warrior husband = WARRIOR.make();
        Warrior wife = WARRIOR.make();

        fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("1. Fight: when warrior fights against knight second should should be alive")
    void fight06() {
        Warrior dragon = WARRIOR.make();
        Warrior knight = KNIGHT.make();

        fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight: when warrior fights against knight and then knight fights against warrior the last should win")
    void fight07() {
        Warrior unit_1 =  WARRIOR.make();
        Warrior unit_2 = KNIGHT.make();
        Warrior unit_3 =  WARRIOR.make();

        fight(unit_1, unit_2);
        boolean res = fight(unit_2, unit_3);

        assertFalse(res);
    }

    @Test
    @DisplayName("Steps in battle 23")
    void battleSteps() {
        Warrior a1 = LANCER.make();
        Warrior a2 = WARRIOR.make();
        Warrior a3 = HEALER.make();
        Warrior a4 = WARRIOR.make();
        Warrior a5 = HEALER.make();
        Warrior a6 = KNIGHT.make();

        Warrior b1 = WARRIOR.make();
        Warrior b2 = DEFENDER.make();
        Warrior b3 = HEALER.make();
        Warrior b4 = VAMPIRE.make();
        Warrior b5 = LANCER.make();

        fight(a1, b1);
        fight(a2, b2);
        fight(a3, b3);
        fight(a4, b4);
        fight(a5, b5);

        fight(a1, b2);
        fight(a3, b5);

        fight(a1, b5);
        fight(a4, b5);
        var res = fight(a6, b5);
        assertTrue(res);

    }

    @Test
    @DisplayName("WarriorVSBerserk")
    void WarriorVSBerserk() {
        var warrior = WARRIOR.make();
        var berserk = BERSERK.make();

        boolean res = fight(warrior, berserk);

        assertAll(
                () ->       assertFalse(res),
                () ->  assertEquals(5, ((AbstractWarrior) berserk).getHealth()),
                () ->   assertEquals(-4, ((AbstractWarrior) warrior).getHealth())
        );

    }

    @Test
    @DisplayName("BerserkVSVampire")
    void BerserkVSVampire() {
        var berserk = BERSERK.make();
        var vampire = VAMPIRE.make();

        boolean res = fight(berserk, vampire);

        assertAll(
                () ->       assertTrue(res),
                () ->  assertEquals(8, ((AbstractWarrior) berserk).getHealth()),
                () ->   assertEquals(-2, ((AbstractWarrior) vampire).getHealth())
        );

    }

    @Test
    @DisplayName("Steps_Battle to check BERSERK_impl")
    void stepsBattle() {
        var berserk = BERSERK.make();
        var vampire = VAMPIRE.make();
        var warrior = WARRIOR.make();
        var defender = DEFENDER.make();

        assertFalse(fight(vampire, defender));
        assertEquals(20, defender.getHealth());
        assertTrue(fight(berserk, defender));
        assertEquals(0, defender.getHealth());
        assertEquals(33, berserk.getHealth());
        assertFalse(fight(berserk, warrior));
        assertEquals(10, warrior.getHealth());
        assertEquals(-2, berserk.getHealth());

    }



}