package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class XM extends Exterior {

	public XM(PartType type) {
		setType(type);
	}
	
	final String  description="Metallic Paint";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>EXTERIOR</h1>");
		p.println("<h2>XM</h2>");
		p.println("<h3>price</h3><p>"+this.getPrice()+"</p>");
		p.println("<h3>Color</h3><p>"+this.getColor()+"</p>");
	}

}
