package menu.domain;

import java.util.List;
import menu.commons.enums.Category;
import menu.commons.exception.FoodException;

public class HateFood {
    private final List<String> foods;

    public HateFood(List<String> foods) {
        validate(foods);
        this.foods = foods;
    }

    public boolean isHateFood(String food){
        return foods.contains(food);
    }

    private void validate(List<String> foods) {
        if (!isValidFoodNumber(foods)) {
            throw new FoodException("못 먹는 메뉴는 최소 0개, 최대 2개입니다.");
        }

        if (!isValidFood(foods)) {
            throw new FoodException("메뉴판에 존재하지 않는 메뉴입니다.");
        }
    }

    private boolean isValidFoodNumber(List<String> foods) {
        if (foods.size() > 2) {
            return false;
        }
        return true;
    }

    private boolean isValidFood(List<String> foods) {
        for (String food : foods) {
            if (Category.hasMenu(food)) {
                return true;
            }
        }
        return false;
    }
}
