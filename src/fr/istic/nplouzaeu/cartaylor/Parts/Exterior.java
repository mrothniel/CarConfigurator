package fr.istic.nplouzaeu.cartaylor.Parts;


import java.util.HashSet;
import fr.istic.nplouzaeu.cartaylor.impl.PartImpl;

public class Exterior extends PartImpl{

	HashSet<String> possibleValues = new HashSet<String>();
	private Color paintColor = Color.Blue ;
	enum Color  {
			Blue,
			White,
			Red
	};
	public Exterior() {
		possibleValues.add(Color.Blue.name());
		possibleValues.add(Color.Red.name());
		possibleValues.add(Color.White.name());
		addProperty("color", ()-> getColor(), (value)->setColor(value), possibleValues);
		addProperty("price", ()-> String.valueOf(getPrice()), null, null);
	}
	
	public String getColor() {
		return paintColor.name();
	}
	
	public void setColor(String value){
		Color newColor=Color.valueOf(value);
		if(newColor!=null) {
			paintColor =newColor;
		}
	}
	
	public double getPrice(){
		switch(paintColor) {
		case Blue: return 200 ;
		case Red: return 400 ;
		case White: return 600 ;
		default: return 0;
		}
	}

}
