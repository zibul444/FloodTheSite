package ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  class Helper
 */
class GameHelper {
    private Logger logger = Logger.getLogger(GameHelper.class.getName());

    private final String alphabet = "abcdefg";
    private final byte gridLength = 7;
    private final byte gridSize = (byte)(gridLength * gridLength);
    private int[] grid = new int[gridSize];
    private byte comCount = 0;
    private Random random = new Random();
    private BufferedReader is = null;

    /**
     *
     * @param prompt    принимаем пользовательские инструкции
     * @return          возвращаем пользовательский ввод
     */
    protected String getUserInput(final String prompt, InputStream in){
        String inputLine = null;
//        System.out.println(prompt + " ");
        logger.log(Level.ALL, prompt + " ");

        try {
            is = new BufferedReader(new InputStreamReader(in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }catch (IOException e){
//            System.out.println("IOException " + e);
            logger.log(Level.ALL, "IOException " + e);
        }
        return inputLine.toLowerCase();
    }

    /**
     *
     * @param comSize размер сайта
     * @return возвращаем персональное место на игровом поле для нового сайта
     */
    protected ArrayList<String> placeDotCom(final int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
//        String [] alphaСoords = new String[comSize]; //182
        String temp;
        int[] coords = new int[comSize];
        short attempts = 0;
        boolean success = false;
        byte location;
        byte incr = 1;

        comCount++;
        if ((comCount % 2) ==1 ){
            incr = gridLength;
        }

        while (!success & attempts++ < 200){
            location = (byte) random.nextInt(gridSize);
            byte x = 0;
            success = true;
            while (success && x < comSize){
                if (grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize){
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)){
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        byte row;
        byte column;
        byte x = 0;
        while (x < comSize){
            grid[coords[x]] = 1;
            row = (byte) (coords[x] / gridLength);
            column = (byte) (coords[x] % gridLength);
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            logger.log(Level.ALL, " coord " + x + " = " + alphaCells.get(x-1)); // Chit
        }
        return alphaCells;
    }
}
