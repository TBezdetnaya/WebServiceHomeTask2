package client;

import convertSpeedService.ConvertSpeedsSoap;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by tanya on 31.05.2017.
 */
public class JAXBClient {

    public ConvertSpeedsSoap convertSpeedsSoap;
    public JAXBClient() {
        try {
            URL url = new URL("\n" + "http://www.webservicex.net/ConvertSpeed.asmx?WSDL");

            //1st argument service URI, refer to wsdl document above
            //2nd argument is service name, refer to wsdl document above
            QName qname = new QName("http://www.webservicex.net/", "ConvertSpeed");

            Service service = Service.create(url, qname);

            convertSpeedsSoap = service.getPort(ConvertSpeedsSoap.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
