package pvt.notebook2.dom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAX {

    public static void main (String[] args) throws FileNotFoundException, XMLStreamException {
        boolean isUrl = false;
        boolean isName = false;
        boolean isPass = false;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(MyDocumentBuilder.class.getClassLoader().getResource(
                    "config.xml").getPath()));
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == XMLStreamReader.START_ELEMENT) {
                    if (reader.getLocalName().equals("url")) {
                        isUrl = true;
                    } else if (reader.getLocalName().equals("user")) {
                        isName = true;
                    } else if (reader.getLocalName().equals("pass")) {
                        isPass = true;
                    }
                } else if (res == XMLStreamReader.CHARACTERS) {
                    if (isUrl) {
                        System.out.println("Url:" + reader.getText());
                        isUrl = false;
                    } else if (isName) {
                        System.out.println("Username:" + reader.getText());
                        isName = false;
                    } else if (isPass) {
                        System.out.println("Password:" + reader.getText());
                        isPass = false;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
