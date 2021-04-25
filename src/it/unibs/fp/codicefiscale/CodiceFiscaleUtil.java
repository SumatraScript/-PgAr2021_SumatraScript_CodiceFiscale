package it.unibs.fp.codicefiscale;

public class CodiceFiscaleUtil {
	/**
	 * Metodo che permette la genereazione dei 3 caratteri del cosice fiscale a
	 * partire dal nome o dal cognome
	 */
	public static String nomeCognome(String input) {
		String output = new String();
		input.toUpperCase();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
				output = output + ch;
			}
		}
		if (output.length() < 3 && input.length() < 3) {
			while(output.length()!=3) {
				output = output + 'X';
			}
		}	
		else if (output.length() < 3) {
			boolean trovato = false;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
					if (trovato == false) {
						output = output + ch;
						trovato = true;
					}
				}
			}
		}
		return output;
	}
	
}
