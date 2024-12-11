package menu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.HateFood;
import menu.domain.Recommender;

public class MenuService {
    public Coaches registerCoaches(String input) {
        List<String> names = parseInput(input);
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            Coach coach = new Coach(name);
            coaches.add(coach);
        }
        return new Coaches(coaches);
    }

    public void registerHateFood(Coach coach,String input){
        List<String> foods = parseInput(input);
        HateFood hateFood = new HateFood(foods);
        coach.setHateFood(hateFood);
    }

    private List<String> parseInput(String input) {
        String[] tokens = input.split(",");
        List<String> output = new ArrayList<>();
        Collections.addAll(output, tokens);
        return output;
    }

    public String recommendMenu(Coaches coaches){
        Recommender recommender = new Recommender(coaches);
        return recommender.toString();
    }
}
