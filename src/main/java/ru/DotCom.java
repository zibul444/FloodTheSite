package ru;
import java.util.ArrayList;

/**
 * Описание свойств класса ru.DotCom
 */
final class DotCom {
    private final String name;

    private ArrayList<String> locationCells;

    /**
     *
     * @param name имя новго сайта
     */
    protected DotCom(final String name) {
        this.name = name;
    }

    /**
     *
     * @param location присваиваем персональное место на игровом поле конкретному сайту
     */
    protected void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    /**
     *
     * @param userGuess ход пользователя
     * @return результат хода пользователя по отнашению к конкретному сайту
     */
    protected String checkYourSelf(final String userGuess) {
        String result = "Промах";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = " Потопил " + name + "!";
            } else {
                result = " Попал в" + name;
            }
        }
        return result;
    }
}
