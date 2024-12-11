package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.commons.enums.Category;

public class Recommender {
    private final List<Category> weeklyCategory;
    private Map<Coach, List<String>> weeklyMenu;

    public Recommender(Coaches coaches) {
        this.weeklyCategory = selectCategory();
        this.weeklyMenu = selectMenu(coaches);
    }

    private List<Category> selectCategory() {
        List<Category> weeklyCategory = new ArrayList<>();
        while (weeklyCategory.size() < 5) {
            Category category = Category.selectCategory();
            if (Collections.frequency(weeklyCategory, category) < 2) {
                weeklyCategory.add(category);
            }
        }
        return weeklyCategory;
    }

    private Map<Coach, List<String>> selectMenu(Coaches coaches) {
        Map<Coach, List<String>> weeklyMenu = registerMap(coaches);
        for (Category category : weeklyCategory) {
            coaches.forEachCoach(coach -> {
                List<String> menu = weeklyMenu.get(coach);
                String food = selectCoachMenu(menu, category, coach);
                menu.add(food);
            });
        }
        return weeklyMenu;
    }

    private Map<Coach, List<String>> registerMap(Coaches coaches) {
        Map<Coach, List<String>> weeklyMenu = new LinkedHashMap<>();
        coaches.forEachCoach(coach -> {
            weeklyMenu.put(coach, new ArrayList<>());
        });
        return weeklyMenu;
    }

    private String selectCoachMenu(List<String> menu, Category category, Coach coach) {
        String food = "";
        while (true) {
            food = Category.selectValidMenu(category);
            if (!coach.isHateFood(food) && !menu.contains(food)) {
                break;
            }
        }
        return food;
    }

    @Override
    public String toString() {
        return categoryToString() + coachMenuToString();
    }

    private String categoryToString() {
        String result = "[ 카테고리 | ";
        for (Category category : weeklyCategory) {
            result += category.name() + " | ";
        }
        result = result.substring(0, result.length() - 3);
        result += " ]\r\n";
        return result;
    }

    private String coachMenuToString() {
        StringBuilder result = new StringBuilder();
        weeklyMenu.forEach(((coach, strings) -> {
            String coachResult = "[ " + coach + " | " + menuToString(strings);
            result.append(coachResult);
        }));
        return result.toString();
    }

    private String menuToString(List<String> menus) {
        StringBuilder result = new StringBuilder();
        for (String menu : menus) {
            result.append(menu).append(" | ");
        }
        result.setLength(result.length() - 3); // 마지막 "| " 제거
        result.append(" ]\r\n");
        return result.toString();
    }
}
