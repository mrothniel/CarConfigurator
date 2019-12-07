package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class IS extends Interior{

	public IS(PartType type) {
		setType(type);
	}
	
	final String  description="Sport finish";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>INTERIOR</h1>");
		p.println("<h2>IS</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
