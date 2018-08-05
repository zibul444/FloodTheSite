import java.io.*;
import java.util.ArrayList;

public class GameHelper {
//    ArrayList<Integer> steps = new ArrayList<>();

    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }catch (IOException e){
            System.out.println("IOException " + e);
        }
//        for (int step : steps) {
//            if (step == Integer.parseInt(inputLine)) {
//                System.out.println("Уже было.");
//                getUserInput(prompt);
//            }
//        }
//        steps.add(Integer.parseInt(inputLine));
        return inputLine;
    }
}
