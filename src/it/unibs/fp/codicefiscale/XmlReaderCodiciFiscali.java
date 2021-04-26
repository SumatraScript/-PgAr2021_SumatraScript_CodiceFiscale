package it.unibs.fp.codicefiscale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlReaderCodiciFiscali {

	public static void main(String[] args) {
		String nome = "DYLAN";
		String cognome = "ZANAGLIO";
		String sesso = "M";
		String comune = "BRESCIA";
		String dataDiNascita = "2001-04-20";
		ArrayList<Comune> comuni = readerComuni();
		String n = "DLN";
		String c = "ZNG";
		String dt = "01D";
		String gt = "20";
		String ct = "B157";
		String tot = "ZNGDLN01D20B157";
		System.out.println(CodiceFiscaleUtil.nomeCognome(nome));
		System.out.println(CodiceFiscaleUtil.nomeCognome(cognome));
		System.out.println(CodiceFiscaleUtil.dataDiNascita(dataDiNascita));
		System.out.println(CodiceFiscaleUtil.giornoDiNascita(dataDiNascita, sesso));
		System.out.println(CodiceFiscaleUtil.comuneDiNascita(comuni, comune));
		System.out.println(CodiceFiscaleUtil.codiceSenzaControllo(c, n, dt, gt, ct));
		System.out.println(CodiceFiscaleUtil.carattereDiControllo(tot));
	}

	public static ArrayList<Comune> readerComuni() {
		File input = new File("src\\xml\\comuni.xml");
		String nome = new String();
		String codice = new String();
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		XMLInputFactory xmlif = XMLInputFactory.newFactory();
		XMLStreamReader xmlr = null;
		ArrayList<String> nomi = new ArrayList<String>();
		ArrayList<String> codici = new ArrayList<String>();
		
		
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
			while (xmlr.hasNext()) {
				if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
					// lettura codice e inizializzazione in un array di string
					if (xmlr.getLocalName().equals("nome")) {
						xmlr.next();
						if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
							nome = xmlr.getText();
							nomi.add(nome);
						}
					}
					// lettura nome e inizializzazione in  un array di string
					else if (xmlr.getLocalName().equals("codice")) {
						xmlr.next();
						if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
							codice = xmlr.getText();
							codici.add(codice);
						}
					}
				}
				xmlr.next();
			}
		}
		catch (XMLStreamException e) {
			e.printStackTrace();
		}
		//iserimento codici e comuni
		for(int i=0;i<nomi.size();i++) {
			Comune comune = new Comune(nomi.get(i),codici.get(i));
			comuni.add(comune);
		}
		return comuni;
	}
}