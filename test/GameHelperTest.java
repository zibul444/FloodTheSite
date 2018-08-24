import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameHelperTest {
    GameHelper helper = new GameHelper();

    @Test
    void testGetUserInput(){
        assertNotNull(helper.getUserInput("Test input"));
    }

    @Test
    void testPlaceDotCom() {
        short dc = 3, i = 0;
        byte lengthSet = getLengthSet();

        assertEquals(0, lengthSet % dc, "Сайты пересекаются на игровом поле   helper.placeDotCom(int )");
    }

    private byte getLengthSet() {
        byte dc = 3, i = 0;
        HashSet<String> set = new HashSet<>();

        while (i++ < 4){
            for (String s : helper.placeDotCom(dc)) {
                set.add(s);
            }
        }
        return (byte) set.size();
    }
}