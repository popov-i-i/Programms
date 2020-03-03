import java.util.*;

public class BankManager {

    private Queue<String> clientQueue = new LinkedList<String>();
    private  Map<String, Integer> clientMap = new LinkedHashMap<String, Integer>();
    private  Set<String> clientSet = new LinkedHashSet<String>();

    public void registerNewClient(Client client) throws WrongName {

            for (String fullName : clientSet) {
                int counterFullName = Levenshtein.calculate(client.getFullName(), fullName);
                if (counterFullName <= 2) {
                    throw new WrongName("Уже есть в Базе");
                }
            }

            clientQueue.add(client.getFullName());
            clientSet.add(client.getFullName());
            for(String name : clientMap.keySet()){
                int counterName = Levenshtein.calculate(client.getName(), name);
                if (counterName <= 2) {
                    int newCountName = clientMap.get(name) + 1;
                    clientMap.put(name, newCountName);
                    return;
                }
            }
            clientMap.put(client.getName(),1);
    }

    public void expireClients(int num) {
        for (int idx = 0; idx < num; idx++) {
            clientQueue.poll();
            int count = clientMap.get(new ArrayList<String>(clientMap.keySet()).get(idx)) - 1;
            clientMap.put(new ArrayList<String>(clientMap.keySet()).get(idx), count);
        }
    }

    public Map<String, Integer> getUniqueNameCount() {
        return clientMap;
    }

    public  Queue<String> getClientQueue() {
        return clientQueue;
    }
}
