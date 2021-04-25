package it.unibs.fp.codicefiscale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlReaderCodiciFiscali {
	
	public static void main(String[] args) {
		File input=new File("src\\xml\\codiciFiscali.xml");
		XMLInputFactory xmlif = XMLInputFactory.newFactory();
		XMLStreamReader xmlr = null;
		try {
			xmlr = xmlif.createXMLStreamReader(new FileInputStream(input));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
				 switch (xmlr.getEventType()) { // switch sul tipo di evento
				 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
				 System.out.println("Start Read Doc " + input); break;
				 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
				 System.out.println(xmlr.getLocalName());
				 for (int i = 0; i < xmlr.getAttributeCount(); i++)
				 System.out.printf( xmlr.getAttributeLocalName(i) + " " + xmlr.getAttributeValue(i));
				 break;
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
				 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
				 System.out.println("-> " + xmlr.getText());
				 break;
				 }
				 xmlr.next();
				}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
