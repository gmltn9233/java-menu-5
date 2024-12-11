package menu.commons.enums;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Category {
    일식("일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    한식("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    중식("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    아시안("아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    양식("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    private final String categoryName;
    private final List<String> foods;

    Category(String categoryName, List<String> foods) {
        this.categoryName = categoryName;
        this.foods = foods;
    }

    public static boolean hasMenu(String input) {
        for (Category category : values()) {
            if (category.foods.contains(input)) {
                return true;
            }
        }
        return false;
    }

    public static Category selectCategory() {
        int index = Randoms.pickNumberInRange(1, 5);
        return Category.values()[index - 1];
    }

    public static String selectValidMenu(Category category) {
        List<String> menus = category.foods;
        return Randoms.shuffle(menus).get(0);
    }


}
