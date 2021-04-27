package it.unibs.fp.codicefiscale;

import java.util.ArrayList;

public class CodiceFiscaleMain {
	public static void main(String[] args) {
//		String nome = "DYLAN";
//		String cognome = "ZANAGLIO";
//		String sesso = "M";
//		String comune = "BRESCIA";
//		String data_di_nascita = "2001-04-20";
//		ArrayList<Comune> comuni = readerComuni();
//		String n = "DLN";
//		String c = "ZNG";
//		String dt = "01D";
//		String gt = "20";
//		String ct = "B157";
//		String tot = "ZNGDLN01D20B157";
//		System.out.println(CodiceFiscaleUtil.nomeCognome(nome));
//		System.out.println(CodiceFiscaleUtil.nomeCognome(cognome));
//		System.out.println(CodiceFiscaleUtil.data_di_nascita(data_di_nascita));
//		System.out.println(CodiceFiscaleUtil.giornoDiNascita(data_di_nascita, sesso));
//		System.out.println(CodiceFiscaleUtil.comune_di_nascita(comuni, comune));
//		System.out.println(CodiceFiscaleUtil.codiceSenzaControllo(c, n, dt, gt, ct));
//		System.out.println(CodiceFiscaleUtil.carattereDiControllo(tot));
		ArrayList<Persona> persone = XmlReader.readerPersona();
		ArrayList<Comune> comuni = XmlReader.readerComuni();
		ArrayList<String> codici_fiscali = CodiceFiscaleUtil.creaCodiceFiscale(persone, comuni) ;
		for(int i=0;i<codici_fiscali.size();i++) {
			System.out.println(codici_fiscali.get(i));
		}
	}

}
