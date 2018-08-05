import java.util.ArrayList;

class DotCom {
    private final String name;
    private ArrayList<String> locationCells;

    DotCom(final String name) {
        this.name = name;
    }

    void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    String checkYourSelf(final String userGuess) {
        String result = "Blunder";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = " Потопил " + name + "!";
            } else {
                result = "Попал в " + name;
            }
        }
        return result;
    }
}
