import com.opencsv.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AccountManager implements MailAccountManager {

    private Database data = Database.getInstance("C:\\Users\\Иван\\IdeaProjects\\Ex_5\\src\\DB.csv");

    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException, IOException {
        try {
            File file = new File(data.database.getName());
            if(hasAccount(email)){
                throw new DuplicateAccountException();
                }
            CSVWriter writer = new CSVWriter(new FileWriter(data.database.getName(), true));
            writer.writeNext((email+","+password+","+person.getInformation()).split(","));
            writer.close();
            }catch (Exception e) {
            e.printStackTrace();
        }

        }



    @Override
    public void removeAccount(String email, String password) {

        try {
//            CSVReader reader = new CSVReader(new FileReader(data.database.getName()), ',','"', 0);
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            int count = allrows.size();
            for(String row: allrows){
                String rowClone = row.replaceAll("\"", "");
                if(rowClone.split(",")[0].equalsIgnoreCase(email) && rowClone.split(",")[1].equalsIgnoreCase(password)){
                    allrows.remove(row);
                    break;
                }

            }

            if (allrows.size()==count){
                throw new WrongCredentialsException();
            }
            CSVWriter writer = new CSVWriter(new FileWriter(data.database.getName()));
            for (String row: allrows){
                writer.writeNext(row.replaceAll("\"","").split(","));
            }
            writer.close();
        }
        catch (Exception | WrongCredentialsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasAccount(String email) {

        try {
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            for(String row: allrows){
                String rowClone = row.replaceAll("\"","");
                if(rowClone.split(",")[0].equals(email)){
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException {

        try {
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            int count= Integer.parseInt(allrows.get(0).replaceAll("\"","").split(",")[6]);
            for(String row: allrows){
                String rowClone = row.replaceAll("\"","");
                if((rowClone.split(",")[0].equals(email) & rowClone.split(",")[1].equals(password))){
                    return new Person(row.split(",")[2],row.split(",")[3],row.split(",")[4],row.split(",")[5]);
                }
            }
            data.appCount();
            count = data.getCount();
            if (count<=5){
                data.setCount(count);
            }
            else{
                count = 0;
                data.setCount(count);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public int numOfAccounts() {

        List<String[]> allrows = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(data.database.getName()), ',','"', 0);
            allrows = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = allrows.size();
        return count;
    }
}
