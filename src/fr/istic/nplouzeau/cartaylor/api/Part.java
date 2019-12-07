/**
 * 
 */
package fr.istic.nplouzeau.cartaylor.api;

import java.io.PrintStream;

/**
 * @author KONAN Kouassi OthnieL
 * @author Fabrice KADIO
 */
public interface Part extends PropertyManager {
	
	default String getName() {
		return this.getClass().getTypeName();
	};
	/**
	 * 
	 * @return the instance of category
	 */
	Category getCategory();
	/**
	 * 
	 * @return the instance of partType 
	 */
	PartType getType();
	void printDescription(PrintStream p);
}
