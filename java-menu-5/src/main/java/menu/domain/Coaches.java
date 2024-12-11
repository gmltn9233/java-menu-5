package menu.domain;

import java.util.List;
import java.util.function.Consumer;
import menu.commons.exception.CoachException;

public class Coaches {
    private final List<Coach> coaches;
    public Coaches (List<Coach> coaches){
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches){
        if(!isValidSize(coaches)){
            throw new CoachException("코치는 최소 2명, 최대 5명 까지 식사가 가능합니다.");
        }
    }

    private boolean isValidSize(List<Coach> coaches){
        if(coaches.size() < 2 || coaches.size() > 5){
            return false;
        }
        return true;
    }

    public void forEachCoach(Consumer<Coach> action){
        for(Coach coach : coaches){
            action.accept(coach);
        }
    }
}
