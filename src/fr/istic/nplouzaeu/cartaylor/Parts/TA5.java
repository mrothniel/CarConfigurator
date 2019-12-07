package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class TA5 extends Transmission {

	public TA5(PartType type) {
		setType(type);
	}
	
	final String  description="Automatic,5 years";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>Transmission</h1>");
		p.println("<h2>TA5</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
