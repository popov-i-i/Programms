import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) throws WrongName {
        Client cl1 = new Client("Иванов Иван Иванович");
        Client cl2 = new Client("Иоанов Иоан Иоанович");
        Client cl3 = new Client("Петров Петр Петрович");


        BankManager manager = new BankManager();
        manager.registerNewClient(cl1);
        manager.registerNewClient(cl2);
        manager.registerNewClient(cl3);

        System.out.println(manager.getUniqueNameCount());
        System.out.println(manager.getClientQueue());
        manager.expireClients(1);
        System.out.println(manager.getUniqueNameCount());
        System.out.println(manager.getClientQueue());
    }
}
