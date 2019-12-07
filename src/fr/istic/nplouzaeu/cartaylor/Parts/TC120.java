package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class TC120 extends Transmission {

	public TC120(PartType type) {
		setType(type);
	}
	
	final String  description="Converter,180kW";
	
	public void printDescription(PrintStream p) {
		p.println("<h1>Transmission</h1>");
		p.println("<h2>TC120</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
