package menu.view;

public class OutputView {
    public static void menuRecommendStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.\r\n");
    }

    public static void recommendResult(String result){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(result);
        System.out.println("추천을 완료했습니다.");
    }
}
