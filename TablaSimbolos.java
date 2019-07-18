//Esta clase contiene la tabla de simbolos
import java.util.*;

public class TablaSimbolos {

	public HashMap tabla;
	public int tamano;

	TablaSimbolos() {
		tabla=new HashMap();
		tamano=0;
	}

	//Inserta un simbolo
	public void insertar(String identificador,int valor) {
		if(!existe(identificador)){
			tamano++;
			tabla.put(new Integer(tamano),new Simbolo(identificador,valor));
		}
	}

	//Existe un simbolo
	public boolean existe(String identificador) {
		boolean retorno=false;
		for(int i=1;i<=tamano;i++) {
			Simbolo s=new Simbolo();
			s=(Simbolo)tabla.get(new Integer(i));
			if(s.getId().equals(identificador)) {
				retorno=true;
				break;
			}
		}
		return retorno;
	}

	//Obtener valor
	public int getValor(String identificador) {
		int retorno=0;
		for(int i=1;i<=tamano;i++) {
			Simbolo s=new Simbolo();
			s=(Simbolo)tabla.get(new Integer(i));
			if(s.getId().equals(identificador)) {
				retorno=s.getValor();
				break;
			}
		}
		return retorno;			
	}

	public void putSimbolo(String identificador,int valor) {
		if(!existe(identificador)) insertar(identificador,valor);
		else {
			for(int i=1;i<=tamano;i++) {
				Simbolo s=new Simbolo();
				s=(Simbolo)tabla.get(new Integer(i));
				if(s.getId().equals(identificador)) {
					tabla.put(new Integer(i),new Simbolo(identificador,valor));
					break;
				}
			}
		}
	}

	public void listar() {
		for(int i=1;i<=tamano;i++) {
			Simbolo s=new Simbolo();
			s=(Simbolo)tabla.get(new Integer(i));
			System.out.println(s.getId()+" "+s.getValor());
		}
	}
}