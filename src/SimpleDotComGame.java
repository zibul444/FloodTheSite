
import java.util.Random;

public class SimpleDotComGame {
    public static void main(String[] args) {
        System.out.println(" Добро пожаловать в игру \"Потопи сайт\"");
        System.out.println(" Правила просты: найди сайт, спрятанный в ячейках под номерами от 0-6. ");

        SimpleDotCom dotCom = new SimpleDotCom();
        boolean isAlive = true;
        String result = "";
        int numberOfGuess = 0;

        GameHelper helper = new GameHelper();

        int randomInt = new Random().nextInt(5);
        int[] dot = new int[] {randomInt, randomInt+1, randomInt+2};
        dotCom.setLocationCells(dot);

        while (isAlive) {
            System.out.println("Your turn " );
//            String guess = ""+ new Random().nextInt(7);
            String guess = helper.getUserInput("Input the number");
            result = dotCom.checkYourSelf(guess);
            numberOfGuess ++ ;
            System.out.println(result + "\n");
            if("Потопил".equals(result) || "Попал".equals(result)){
                if("Потопил".equals(result)){
                    System.out.println("\nВы потопили сайт за " + numberOfGuess + " ходов");
                    isAlive = false;
                }
            }
        }
        System.out.println("\nСпасибо за игру!");
    }
}
