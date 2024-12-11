package menu.controller;

import menu.commons.exception.MenuException;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void menuRecommend() {
        Coaches coaches = registerCoaches();
        registerHateFoods(coaches);
        recommendResult(coaches);
    }

    private Coaches registerCoaches() {
        OutputView.menuRecommendStart();
        while (true) {
            try {
                String coachRequest = InputView.coachNameRequest();
                return menuService.registerCoaches(coachRequest);
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void registerHateFoods(Coaches coaches) {
        while (true) {
            try {
                coaches.forEachCoach(coach -> {
                    String input = InputView.hateFoodRequest(coach);
                    menuService.registerHateFood(coach, input);
                });
                return;
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void recommendResult(Coaches coaches){
        String result = menuService.recommendMenu(coaches);
        OutputView.recommendResult(result);
    }

}
