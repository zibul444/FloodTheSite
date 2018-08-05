import java.util.ArrayList;

class DotCom {
    private String name;
    private ArrayList<String> locationCells;

    protected DotCom(String name) {
        this.name = name;
    }

    protected void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    protected String checkYourSelf(String userGuess) {

        System.out.println("userGuess = " + userGuess);
        String result = "Blunder";
        int index = locationCells.indexOf(userGuess);

        if (index >= 0){
            locationCells.remove(index);
            System.out.println("isEmpty = " + locationCells.isEmpty());
            if (locationCells.isEmpty()){
                result = "Потопил";
            } else {
                result = "Попал";
            }
        }
        return result;
    }
}
