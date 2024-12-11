package menu.commons.exception;

public class MenuException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    public MenuException(String message){
        super(PREFIX + message);
        this.errorMessage = PREFIX + message;
    }
}
