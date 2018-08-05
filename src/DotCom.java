import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;


    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public String checkYourSelf(String userGuess) {

        int index = locationCells.indexOf(userGuess);

        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                return "Потопил";
            } else {
                return "Попал";
            }
        }
        return "Промах";
    }
}
