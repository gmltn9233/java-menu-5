package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Menu;
import menu.commons.exception.MenuException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachTest {

    @Test
    void 코치의_이름이_2글자_미만이면_예외발생(){
        assertThatThrownBy(() -> new Coach(""))
                .isInstanceOf(MenuException.class);
    }

    @Test
    void 코치의_이름이_2글자_미만이면_예외발생_메시지(){
        MenuException exception = assertThrows(MenuException.class, ()-> new Coach(""));
        assertEquals("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"앗", "우테코붙고싶어요"})
    void 코치의_이름이_2글자_미만이거나_4글자_초과인_경우_예외발생(){
        MenuException exception = assertThrows(MenuException.class, ()-> new Coach(""));
        assertEquals("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.", exception.getMessage());
    }
}
