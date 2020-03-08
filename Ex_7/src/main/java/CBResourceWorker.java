import kong.unirest.Unirest;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class CBResourceWorker implements ResourceWorker {

    public CurrencyInfo currencyOutput;
    private String path;

    public CBResourceWorker(){
        this.path = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    }


    public void getCurrency(String code, String date)  throws UserException, ParserConfigurationException, IOException, SAXException {
        File out = Unirest.get(this.path+date)
                .asFile("FCM.xml")
                .getBody();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("FCM.xml"));

        NodeList currencyElements = document.getDocumentElement().getElementsByTagName("Valute");

        if(currencyElements.getLength() == 0) {
            out.delete();
            throw new UserException("Прогнозирование недоступно");
        }

        for (int i = 0; i < currencyElements.getLength(); i++) {
            Node currency = currencyElements.item(i);
            String charCode = currency.getChildNodes().item(1).getTextContent();

            if (charCode.equalsIgnoreCase(code)) {
                NodeList childNodes = currency.getChildNodes();
                this.currencyOutput = new CurrencyInfo(childNodes.item(1).getTextContent(),
                        Integer.valueOf(childNodes.item(2).getTextContent()),
                        childNodes.item(3).getTextContent(),
                        Float.valueOf(childNodes.item(4).getTextContent().replace(",", ".")));
                break;
            }
            if(i == currencyElements.getLength()-1){
                out.delete();
                throw new UserException("Проверьте корректность введенного CharCode");
            }
        }
        out.delete();
    }

    @Override
    public CurrencyInfo getCurrencyByDate(String code, String date) throws ParserConfigurationException, SAXException, UserException, IOException {
        getCurrency(code, date);
        return this.currencyOutput;
    }
}
