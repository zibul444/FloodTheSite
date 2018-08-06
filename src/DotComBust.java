
import java.util.ArrayList;

class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>(3);
    private byte numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
        game.finishGame();
    }

    private void setUpGame(){
        for (int i = 1; i <= 3; i++) {
            dotComList.add(new DotCom(i + ".com"));
        }
        for (DotCom dotCom : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotCom.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while (!dotComList.isEmpty()){
            String userMove = helper.getUserInput("Make your move:");
            checkUserGuess(userMove);
        }
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Blunder";
        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.contains("Потопил")) {
                dotComList.remove(dotComToTest);
                break;
            } else if (result.contains("Попал")) {
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Game over, mission accomplished.");

        if (numOfGuesses < 20){
            System.out.println(" Congratulations, good game!!!");
            System.out.println(" Your account is" + numOfGuesses);
        } else {
            System.out.println("My grandmother plays better than you...");
            System.out.println(" Your account is " + numOfGuesses + "!");
        }
    }
}
