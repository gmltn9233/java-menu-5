package menu.domain;

import menu.commons.exception.CoachException;

public class Coach {
    private final String name;
    private HateFood hateFood;

    public Coach(String name){
        validate(name);
        this.name = name;
    }

    public void setHateFood(HateFood hateFood) {
        this.hateFood = hateFood;
    }

    private void validate(String name){
        if(!isValidNameLength(name)){
            throw new CoachException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }

    private boolean isValidNameLength(String name){
        if(name.length() < 2 || name.length() > 4){
            return false;
        }
        return true;
    }

    public boolean isHateFood(String food){
        return hateFood.isHateFood(food);
    }

    @Override
    public String toString() {
        return name;
    }
}
