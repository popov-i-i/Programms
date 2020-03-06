import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserWork {

    final static String NEW_FORMAT = "dd-MM-yyyy";
    final static String OLD_FORMAT = "yyyy-MM-dd";

    public static EnteredData collectUserData() throws UserException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter date(YYYY-MM-DD): ");
        String inDate = in.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(inDate);
            sdf.applyPattern(NEW_FORMAT);
            inDate = sdf.format(d);
        }catch (java.text.ParseException ex){
            throw new UserException("Данные некорректны");
        }
        System.out.print("Enter CharCode: ");
        String inCharCode = in.nextLine();

        System.out.print("Enter file path to save data: ");
        String pathToFile = in.nextLine();
        return new EnteredData(inCharCode,inDate,pathToFile);
    }

}
