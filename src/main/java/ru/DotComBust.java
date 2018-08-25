package ru;

import java.util.ArrayList;

/**
 * Игровой класс
 */
final class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>(3);
    private byte numOfGuesses = 0;

    /**
     * main метод
     * @param args пораметры не используются в даннй версии
     */
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
        game.finishGame();
    }

    /**
     * Метод инициализации игры.
     * Создаем сайты, размещаем их на игровом поле.
     */
    private void setUpGame(){
        for (int i = 1; i <= 3; i++) {
            dotComList.add(new DotCom(i + ".com"));
        }
        for (DotCom dotCom : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotCom.setLocationCells(newLocation);
        }
    }

    /**
     * Игровой цикл
     */
    private void startPlaying(){
        while (!dotComList.isEmpty()){
            String userMove = helper.getUserInput("Make your move:", System.in);
            checkUserGuess(userMove);
        }
    }

    /**
     * Проверка Хода пользователя по всем имеющимся сайтам
     * @param userGuess ход пользователя
     */
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Промах";
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

    /**
     * Конец игры, вывод результатов.
     */
    private void finishGame(){
        System.out.println("Game over, mission accomplished.");

        if (numOfGuesses < 20){
            System.out.println(" Congratulations, good game!!!");
            System.out.println(" Your score is " + numOfGuesses + "!");
        } else {
            System.out.println("My grandmother plays better than you...");
            System.out.println(" Your score is " + numOfGuesses + "...");
        }
    }
}