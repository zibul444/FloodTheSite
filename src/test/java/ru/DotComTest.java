package ru;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DotComTest {

    @Test
    void testCheckYourSelf() {
        String name = "Test.com", expected = " Потопил " + name + "!", actual = getResult(name);
        assertTrue(actual.equals(expected), "Сайт не был там где его поставили!");
    }

    /**
     * Метод возвращает
     * @param name
     * @return
     */
    private String getResult(String name) {
        String actual = "";
        DotCom dotCom = new DotCom(name);
        ArrayList<String> location = new GameHelper().placeDotCom(3);
        dotCom.setLocationCells((ArrayList)location.clone());

        for (String s : location) {
            actual = dotCom.checkYourSelf(s);
        }

        return actual;
    }
}