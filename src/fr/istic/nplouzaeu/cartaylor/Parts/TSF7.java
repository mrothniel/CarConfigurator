package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class TSF7 extends Transmission{

	public TSF7(PartType type) {
		setType(type);
	}
	
	final String  description="Sequential, 7 years 4 wheels drive";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>Transmission</h1>");
		p.println("<h2>TSF7</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
