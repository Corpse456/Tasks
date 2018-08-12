package pvt.notebook2.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDocumentBuilder {

    public static void main (String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        File f = new File(MyDocumentBuilder.class.getClassLoader().getResource("config.xml").getPath());
        try {
            doc = builder.parse(f);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = doc.getDocumentElement();
        System.out.println(root.getTagName());
        NamedNodeMap attributes = root.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println(attributes.item(i));
        }
        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        NodeList nList = root.getChildNodes();
        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i) instanceof Element) {
                System.out.println(nList.item(i).getTextContent());
            }
        }
    }
}
