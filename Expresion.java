//Esta clase contiene las expresiones
public class Expresion {

	int contenido;

	Expresion(){
		contenido=0;
	}

	Expresion(int contenido){
		this();
		this.contenido=contenido;
	}

	public void setContenido(int contenido) {
		this.contenido=contenido;
	}

	public int getContenido() {
		return contenido;
	}
}