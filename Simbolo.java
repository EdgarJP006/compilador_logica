public class Simbolo {

	String id;
	int valor;

	Simbolo() {
		id="";
		valor=0;
	}

	Simbolo(String id,int valor) {
		this.id=id;
		this.valor=valor;
	}

	int getValor() {
		return valor;
	}

	String getId() {
		return id;
	}
}