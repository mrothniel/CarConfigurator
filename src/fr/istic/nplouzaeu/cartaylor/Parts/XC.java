package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class XC extends Exterior {

	public XC(PartType type) {
		setType(type);
	}
	
	final String  description="Classic Paint";
	
	public void printDescription(PrintStream s) {
		s.println("<h1>EXTERIOR</h1>");
		s.println("<h2>XC</h2>");
		s.println("<h3>price</h3><p>"+this.getPrice()+"</p>");
		s.println("<h3>Color</h3><p>"+this.getColor()+"</p>");
		s.println("<h3>price</h3><p>"+description+"</p>");
	}

}
