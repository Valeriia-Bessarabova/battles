package khnu.mizhfac.bessarabova.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static khnu.mizhfac.bessarabova.game.Game.straightFight;
import static khnu.mizhfac.bessarabova.game.WarriorClasses.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {

    @Test
    @DisplayName("1. Battle: 1 warrior loses 2 warriors")
    void battle01(){
        var army1 = new Army().addUnits(WARRIOR, 1);
        var army2 = new Army().addUnits(WARRIOR, 2);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }
    @Test
    @DisplayName("2. Battle: 20 warrior and 5 knights loses 30 warriors")
    void battle02(){
        var army1 = new Army()
                .addUnits(WARRIOR, 20)
                .addUnits(KNIGHT, 5);
        var army2 = new Army()
                .addUnits(WARRIOR, 30);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("3. Battle: 5 warriors loses 7 warriors")
    void battle03(){
        var army1 = new Army()
                .addUnits(WARRIOR, 5);
        var army2 = new Army()
                .addUnits(WARRIOR, 7);

        var res = Game.fight(army1, army2);

        assertFalse(res);

    }

    @Test
    @DisplayName("4. Battle: 2 warriors loses 3 warriors")
    void battle04() {
        var army1 = new Army()
                .addUnits(WARRIOR, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 3);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("5. Battle: 20 warriors win 21 warriors")
    void battle05() {
        var army1 = new Army()
                .addUnits(WARRIOR, 20);
        var army2 = new Army()
                .addUnits(WARRIOR, 21);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("6. Battle: 10 warriors win 11 warriors")
    void battle06() {
        var army1 = new Army()
                .addUnits(WARRIOR, 10);
        var army2 = new Army()
                .addUnits(WARRIOR, 11);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("7. Battle: 5 warriors and 9 defenders win 4 warriors")
    void battle07() {
        var army1 = new Army()
                .addUnits(WARRIOR, 5)
                .addUnits(DEFENDER, 5)
                .addUnits(DEFENDER, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("8. Battle: 20 warriors and 9 defenders win 21 warriors")
    void battle08() {
        var army1 = new Army()
                .addUnits(DEFENDER, 5)
                .addUnits(WARRIOR, 20)
                .addUnits(DEFENDER, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 21);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("9. Battle: 10 warriors and 15 defenders win 5 warriors")
    void battle09() {
        var army1 = new Army()
                .addUnits(WARRIOR, 10)
                .addUnits(DEFENDER, 5)
                .addUnits(DEFENDER, 10);
        var army2 = new Army()
                .addUnits(WARRIOR, 5);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("10. Battle: 1 warriors and 3 defenders lose 5 warriors")
    void battle10() {
        var army1 = new Army()
                .addUnits(DEFENDER, 2)
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1);
        var army2 = new Army()
                .addUnits(WARRIOR, 5);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("11. Battle: 7 warriors, 6 vampires and 5 defenders lose 6 warriors, 6 vampires and 6 defenders ")
    void battle11() {
        var army1 = new Army()
                .addUnits(DEFENDER, 5)
                .addUnits(VAMPIRE, 6)
                .addUnits(WARRIOR, 7);
        var army2 = new Army()
                .addUnits(WARRIOR, 6)
                .addUnits(DEFENDER, 6)
                .addUnits(VAMPIRE, 6);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("12. Battle: 2 warriors, 3 vampires and 4 defenders lose 4 warriors, 3 vampires and 4 defenders ")
    void battle12() {
        var army1 = new Army()
                .addUnits(DEFENDER, 4)
                .addUnits(WARRIOR, 2)
                .addUnits(VAMPIRE, 3);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 3);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("13. Battle: 4 warriors, 3 vampires and 11 defenders win 4 warriors, 13 vampires and 4 defenders ")
    void battle13() {
        var army1 = new Army()
                .addUnits(DEFENDER, 11)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 13);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("14. Battle: 8 warriors, 3 vampires and 9 defenders win 4 warriors, 13 vampires and 4 defenders ")
    void battle14() {
        var army1 = new Army()
                .addUnits(DEFENDER, 9)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 8);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 13);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Battle: 15")
    void battle15() {
        var army1 = new Army()
                .addUnits(LANCER, 5)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 5);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Battle: 16")
    void battle16() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Battle: 17")
    void battle17() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Battle: 18")
    void battle18() {
        var army1 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(WARRIOR, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Battle: 19 -- straight fight")
    void battle19() {
        var army1 = new Army()
                .addUnits(LANCER, 5)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 5);

        var res = straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Battle: 20 -- straight fight")
    void battle20() {
        var army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 2);
        var army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);

        var res = straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Battle: 21 -- straight fight")
    void battle21() {
        Army army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(DEFENDER, 2);

        Army army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 6)
                .addUnits(LANCER, 4);

        var res = straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Battle: 22 -- straight fight")
    void battle22() {
        Army army1 = new Army()
                .addUnits(LANCER, 4)
                .addUnits(WARRIOR, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 2);

        Army army2 = new Army()
                .addUnits(WARRIOR, 4)
                .addUnits(DEFENDER, 4)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 2)
                .addUnits(LANCER, 4);

        var res = straightFight(army1, army2);

        assertTrue(res);

    }

    @Test
    @DisplayName("Battle: 23 -- straight fight")
    void battle23() {
        Army army1 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(WARRIOR, 1)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 1)
                .addUnits(HEALER, 1)
                .addUnits(KNIGHT, 1);

        Army army2 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1)
                .addUnits(HEALER, 1)
                .addUnits(VAMPIRE, 1)
                .addUnits(LANCER, 1);

        var res = straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Battle: 24 -- straight fight")
    void battle24() {
        var army1 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(VAMPIRE, 1)
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1);
        var army2 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1)
                .addUnits(VAMPIRE, 1)
                .addUnits(LANCER, 1);

        var res = straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Battle: 25 -- straight fight")
    void battle25() {
        Army army1 = new Army()
                .addUnits(LANCER, 1)
                .addUnits(HEALER, 1);

        Army army2 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(VAMPIRE, 1);

        var res = straightFight(army1, army2);

        assertFalse(res);



    }


}

