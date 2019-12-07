package fr.istic.nplouzaeu.cartaylor.Parts;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ED110 extends Engine {
	
	final String  description="Diesel , 110kW";

	public ED110(PartType type) {
		setType(type);
	}
	
	@Override
	public void printDescription(PrintStream p) {
		p.println("<h1>ENGINE</h1>");
		p.println("<h2>ED110</h2>");
		p.println("<h3>Description</h3><p>"+description+"</p>");
	}
	

}
