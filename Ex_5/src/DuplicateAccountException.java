public class DuplicateAccountException extends Exception {
    public DuplicateAccountException(){
        super("Данный аккаунт уже существует");
    }

}
