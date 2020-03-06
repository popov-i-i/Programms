import java.io.FileWriter;
import java.io.IOException;

public class FileCurrencyProcessor implements CurrencyProcessor {
    private String filePath;
    private String date;

    public FileCurrencyProcessor(String filePath, String date){
        this.filePath = filePath;
        this.date = date;

    }

    @Override
    public void saveCurrency(CurrencyInfo currencyInfo)  throws IOException  {
        try(FileWriter fwriter = new FileWriter(filePath, true)){
            fwriter.write(currencyInfo.toString()+ ", на " + this.date.replace("-", ".") + "\n");
        }
    }
}
