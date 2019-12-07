package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class TM6 extends Transmission {

	public TM6(PartType type) {
		setType(type);
	}
	
	final String  description="Manual, 6 years";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>Transmission</h1>");
		p.println("<h2>TM6</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
