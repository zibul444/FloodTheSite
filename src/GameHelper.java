import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

class GameHelper {
    private final String alfabet = "abcdefg";
    private final byte gridLength = 7;
    private final byte gridSize = (byte)(gridLength * gridLength);
    private int[] grid = new int[gridSize];
    private byte comCount = 0;
    private Random random = new Random();

    protected String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }catch (IOException e){
            System.out.println("IOException " + e);
        }
        return inputLine.toLowerCase();
    }

    protected ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
        String [] alphacoords = new String[comSize]; //182 стр - разобраться
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

        byte x = 0;
        byte row;
        byte column;
        while (x < comSize){
            grid[coords[x]] = 1;
            row = (byte) (coords[x] / gridLength);
            column = (byte) (coords[x] % gridLength);
            temp = String.valueOf(alfabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
//            System.out.println(" cord " + x + " = " + alphaCells.get(x-1)); // Chit
        }
        return alphaCells;
    }
}
