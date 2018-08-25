package ru;

import org.junit.jupiter.api.Test;
import ru.GameHelper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameHelperTest {
        static GameHelper helper = new GameHelper();


//    @Disabled
    @Test
    void testGetUserInput(){
//        InputStream stream = new ByteInputStream();
        String expected = "123";
        InputStream stream = new ByteArrayInputStream(expected.getBytes(Charset.forName("UTF-8")));

        assertEquals(Integer.valueOf(expected), Integer.valueOf(helper.getUserInput("Test input", stream)), "Метод вернул что-то свое О_о");
    }

    @Test
    void testPlaceDotCom() {
        short lengthDC = 3;
        byte lengthSet = getLengthSet();

        assertEquals(0, lengthSet % lengthDC, "Сайты пересекаются на игровом поле   helper.placeDotCom(int )");
    }

    private byte getLengthSet() {
        byte lengthDC = 3, i = 0;
        HashSet<String> set = new HashSet<String>();
        byte countDotCom = 4;
        while (i++ < countDotCom){
            for (String s : helper.placeDotCom(lengthDC)) {
                set.add(s);
            }
        }
        return (byte) set.size();
    }
}