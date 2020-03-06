public class WrongCredentialsException extends Error {
    public WrongCredentialsException() {
        super("Пользователь не найден");
    }

}
