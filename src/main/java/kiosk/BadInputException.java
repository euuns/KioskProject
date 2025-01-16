package kiosk;

public class BadInputException extends Exception {
    public BadInputException() {
        super("잘못된 입력입니다. 다시 입력해주세요.");
    }
}
