package fr.istic.nplouzeau.cartaylor.api;
/**
 * 
 * @author Konan Kouassi Othniel
 * @author Kadio Fabrice
 */
public interface PartType {
	/**
	 * 
	 * @return the category to which the PartType belongs 
	 */
	public Category getCategory() ;
	/**
	 * 
	 * @return the partType name
	 */
	public String getName();
	/**
	 * 
	 * @return the partType description
	 */
	
	public String getDescription();
}
