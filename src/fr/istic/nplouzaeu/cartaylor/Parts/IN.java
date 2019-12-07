package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class IN extends Interior {

	public IN(PartType type) {
		setType(type);
	}
	
	final String  description="Standard Interior";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>INTERIOR</h1>");
		p.println("<h2>IN</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
