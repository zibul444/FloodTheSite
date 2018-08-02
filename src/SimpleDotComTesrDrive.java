public class SimpleDotComTesrDrive {
    public static void main(String[] args) {
        SimpleDotCom dotCom = new SimpleDotCom();

        int[] location = {2, 3, 4};
        dotCom.setLocationCells(location);
        String userGuess = "3";
        String result = dotCom.checkYourSelf(userGuess);

        String testResult = "Неудача";
        if (result.equals("Попал")){
            testResult = "Пройден";
        }

        System.out.println("testResult = " + testResult);
    }
}
