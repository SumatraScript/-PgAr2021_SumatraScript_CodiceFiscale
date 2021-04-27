package it.unibs.fp.codicefiscale;

import java.util.ArrayList;

/**
 * Classe realizzata per confrontare i codici 
 * fiscali contenuti nell xml con i codici fiscali 
 * ottenuti tramite calcolo dal file imput persone 
 */
public class XmlCompare {
	public static ArrayList<String> codiciFiscaliCompare(ArrayList<String> codici_ottenuti, ArrayList<String> codici_prelevati, ArrayList<Persona> persone) {
		ArrayList<String> codici_fiscali_invalidi = new ArrayList<String>();
		for(int i=0;i<codici_ottenuti.size();i++) {
			for(int j=0;j<codici_prelevati.size();j++) {
				if(codici_ottenuti.get(i).equals(codici_prelevati.get(j)))
					persone.get(i).setCodice_fiscale(codici_ottenuti.get(i));
				else
					codici_fiscali_invalidi.add(codici_prelevati.get(j));
			}
		}
		return codici_fiscali_invalidi;
	}
}

