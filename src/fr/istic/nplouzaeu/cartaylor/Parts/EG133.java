package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class EG133 extends Engine {

	public EG133(PartType type) {
		setType(type);
	}
	
	final String  description="Gasoline , 133kW";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>ENGINE</h1>");
		p.println("<h2>EG133</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
