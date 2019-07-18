// Esta clase se utiliza para crear el fichero que contiene el codigo intermedio

import java.io.*;
import java.util.*;

class CodigoIntermedio {
	String nombreFichero = null;
	PrintWriter ficheroEscritura;
	Vector instrucciones;

	
	// Constructor
	public CodigoIntermedio(String nombre) {
		nombreFichero = nombre;
		ficheroEscritura = null;
		crearInstrucciones();
	}

	// Crea una tabla indicando todas las instrucciones que deben escribir
	// el numero de linea
	private void crearInstrucciones() {
		instrucciones = new Vector();
	}

	// Abre un nuevo fichero donde guardar codigo
	public void abrirFicheroEscritura() throws IOException {
		ficheroEscritura = new PrintWriter(
			new BufferedWriter(
				new FileWriter(nombreFichero)));
	}

	// Cierra el fichero de escritura
	public void cerrarFicheroEscritura() {
		for(int i=0;i<instrucciones.size();i++) ficheroEscritura.println((String)instrucciones.elementAt(i));
		ficheroEscritura.close();
	}

	public void escribir(String cadena) {
		if(instrucciones.size()<1)escribirLn("");
		String cade=instrucciones.elementAt(instrucciones.size()-1)+cadena;
		instrucciones.setElementAt(quitaComillas(cade),instrucciones.size()-1);
	}

	public void escribirLn(String cadena) {
		instrucciones.addElement(cadena);
	}

  	private String quitaComillas(String s) {
     		if (s.substring(0,1).equals("\"")) {
       			return (s.substring(1,s.length()-1));
     		} else {
       			return s;
     		}
  	}
}