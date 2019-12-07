package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class XS extends Exterior {

	public XS(PartType type) {
		setType(type);
	}
	
	final String  description="Red Paint and sport decoration";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>EXTERIOR</h1>");
		p.println("<h2>XS</h2>");
		p.println("<h3>price</h3><p>"+this.getPrice()+"</p>");
		p.println("<h3>Color</h3><p>"+this.getColor()+"</p>");
	}

}
