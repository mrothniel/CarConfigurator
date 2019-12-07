package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class EH120 extends Engine {

	public EH120(PartType type) {
		setType(type);
	}
	
	final String  description="Gasoline/electric hybrid , 120kW";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>ENGINE</h1>");
		p.println("<h2>EH120</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
