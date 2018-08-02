public class SimpleDotCom {

    private int[] locationCells;
    private int numberOfHits = 0;

    public void setLocationCells(int[] location) {
        locationCells = location;
    }

    public String checkYourSelf(String userGuess) {
        String result = "Промах";
        System.out.println(userGuess);
        int guess = Integer.parseInt(userGuess);
        for (int cells : locationCells){
            if (cells == guess){
                numberOfHits++;
                result = "Попал";
                break;
            }
        }
        if (numberOfHits == 3){
            result = "Потопил";
        }
        return result;
    }
}
