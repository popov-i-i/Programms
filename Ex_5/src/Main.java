import java.io.IOException;


public class Main {
    public static void main(String[] args) throws DuplicateAccountException, IOException, TooManyLoginAttemptsException {
        Person person1 = new Person("First", "First1","First2", "01-01-2000");
        Person person2 = new Person("Second", "Second1","Second2", "02-02-2000");
        Person person3 = new Person("Third", "Third1","Third2", "03-03-2000");
        MailAccountManager database = new AccountManager();
//        database.registerNewAccount("first1","123",person1);
//        database.registerNewAccount("second2","456",person2);
//        database.registerNewAccount("third3","7890",person3);
        database.removeAccount("first1","123");
        System.out.println(database.hasAccount("first1"));
        System.out.println(database.numOfAccounts());
        System.out.println(database.getPerson("third3","7890"));
    }
}
