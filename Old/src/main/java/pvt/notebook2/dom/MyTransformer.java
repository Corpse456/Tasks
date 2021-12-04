package pvt.notebook2.dom;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class MyTransformer {

	public static void main(String[] args) {
		Document doc = new MyDocumentBuilder().docExecutor();
		
		File stylesheet = new File("src/main/java/pvt/notebook2/dom/XmlToHtml.xsl");
		StreamSource styleSource = new StreamSource(stylesheet);
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
			t.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(System.out));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
