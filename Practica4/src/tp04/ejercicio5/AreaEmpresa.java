package tp04.ejercicio5;

public class AreaEmpresa {
	String id;
	int tardanza;
	
	public AreaEmpresa(String id, int tardanza) {
		setId(id);
		setTardanza(tardanza);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTardanza() {
		return tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
}
