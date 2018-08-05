import java.util.ArrayList;

public class SimpleDotComTesrDrive {
    public static void main(String[] args) {
        DotCom dotCom = new DotCom();

        ArrayList<String> location = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            location.add(i + "");
        }
        dotCom.setLocationCells(location);
        String userGuess = "2";
        String result = dotCom.checkYourSelf(userGuess);

        String testResult = "Неудача";
        if (result.equals("Попал")){
            testResult = "Пройден";
        }

        System.out.println("testResult = " + testResult);
    }
}
