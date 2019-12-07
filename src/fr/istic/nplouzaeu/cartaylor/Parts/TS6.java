package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class TS6 extends Transmission{

	public TS6(PartType type) {
		setType(type);
	}
	
	final String  description="Sequential, 6 years";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>Transmission</h1>");
		p.println("<h2>TS6</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
