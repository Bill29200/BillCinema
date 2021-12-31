package ihm;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private String nomTable;
	private List<String> nomColonnes;
	private List<Object> enregistrement;
	private List<List<Object>> listEnregistrement;
	
	public Model(String nom) {
		this.nomTable=nom;
		this.nomColonnes=new ArrayList<>();
		this.enregistrement=new ArrayList<>();
		this.listEnregistrement=new ArrayList<>();
	}
	public String getNomTable() {
		return nomTable;
	}
	public void setNomTable(String nomTable) {
		this.nomTable = nomTable;
	}
	public List<String> getNomColonnes() {
		return nomColonnes;
	}
	public void setNomColonnes(List<String> colonnes) {
		this.nomColonnes = colonnes;
	}
	public List<Object> getEnregistrement() {
		return enregistrement;
	}
	public void setEnregistrement(List<Object> enregistrement) {
		this.enregistrement = enregistrement;
	}
	
	public void setListEnregistrement(List<List<Object>> listEnregistrement) {
		this.listEnregistrement = listEnregistrement;
	}
	public List<List<Object>> getListEnregistrement() {
		return listEnregistrement;
	}
	
	

	
	
	
	
	
	
	
	
}
