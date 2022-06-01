package adoptaPet;

import java.util.ArrayList;

import javax.swing.JButton;

public class PetsArrayList {

	protected ArrayList<Pet> petsArrayList;
	
	//constructor
	public PetsArrayList() {
		
		petsArrayList=new ArrayList<>();
	}
	
	
	//metodo para añadir mascota al ArrayList
	public void addPetArrayList(Pet p)
	{
		petsArrayList.add(p);
	}

	//metodo para saber cuantos animales hay en el ArrayList
	public int size()
	{
		return petsArrayList.size();
	}
	
	//getter and setter
	public ArrayList<Pet> getPetsArrayList() {
		return petsArrayList;
	}


	public void setPetsArrayList(ArrayList<Pet> petsArrayList) {
		this.petsArrayList = petsArrayList;
	}


	@Override
	public String toString() {
		return "PetsArrayList [petsArrayList=" + petsArrayList + "]";
	}
	
	
	
}
