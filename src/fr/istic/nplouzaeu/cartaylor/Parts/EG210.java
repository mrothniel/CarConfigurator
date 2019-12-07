package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class EG210 extends Engine {

	public EG210(PartType type) {
		setType(type);
	}
	
	final String  description="Gasoline , 210kW";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>ENGINE</h1>");
		p.println("<h2>EG210</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
