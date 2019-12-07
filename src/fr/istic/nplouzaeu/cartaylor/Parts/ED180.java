package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ED180 extends Engine {

	public ED180(PartType type) {
		setType(type);
	}
	
	final String  description="Diesel , 180kW";
	
	@Override
	public void printDescription(PrintStream p) {
		p.println("<h1>ENGINE</h1>");
		p.println("<h2>ED180</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}

}
