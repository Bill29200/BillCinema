package bo;

import java.util.ArrayList;
import java.util.List;

public class Table implements Cloneable{

	private String nomTable;
	protected List<String> nomColonnes;
	protected List<Object> donnees;
	
	public Table(String nomTable) {
		this.nomTable = nomTable;
		this.donnees = new ArrayList<>();
		this.nomColonnes = new ArrayList<>();
	}

	
	public Table clone() throws CloneNotSupportedException { return (Table)
	  super.clone(); }
	 

	public List<Object> getDonnee() {
		// TODO Auto-generated method stub
		return this.donnees;
	}

	public void setDonnee(List<Object> donnee) throws Exception {
		this.donnees = donnee;
	}
	
	

	public List<String> getColonnes() {
		return nomColonnes;
	}

	public void setColonnes(List<String> colonnes) {
		this.nomColonnes = colonnes;
	}

	public void addDonnee(Object donnee) {
		this.donnees.add(donnee);
	}

	public String getNomTable() {
		return this.nomTable;
	}

	@Override
	public String toString() {
		String str=nomTable + " [";
		str+=(this.donnees.size()>0?this.nomColonnes.get(0) + "=" +this.donnees.get(0):"");
		for (int i = 1; i < this.donnees.size(); i++) {
			str+=", "+this.nomColonnes.get(i) + "=" +this.donnees.get(i);
		}
		return str+"]";
	}

}
