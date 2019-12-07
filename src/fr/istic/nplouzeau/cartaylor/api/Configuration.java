package fr.istic.nplouzeau.cartaylor.api;


import java.io.PrintStream;
import java.util.Optional;
import java.util.Set;

public interface Configuration {
	/**
	 * check if all the parts have their parts required and if the incompatibilities have not been chosen
	 * 
	 * @return true if there is no incompatibility between parts of the vehicle (PartType)
	 * and all required parts are available in the configuration
	 * otherwise false
	 */

    boolean isValid();
    /**
      *check if all configuration choices are made
      *
      * @return true if the configuration contains a choice of parts by category
     */

    boolean isComplete();
   
    /**
     * Selects all the pieces of the configuration
     */

    Set<Part> getSelectedParts();
    
    /**
     * selection of a piece passed as parameters for configuration
     * @param chosenPart the choice of users
     */

    void selectPart(PartType chosenPart);
    
    /**
     * 
     * @param category will be used as a key to find the choice of this category
     * @return the selected part for the category passed in parameters
     */

    public Optional<Part> getSelectionForCategory(Category category);
    
    /**
     * delete the part passed as parameters if it was previously selected
     * @param categoryToClear the part to remove
     */

    void unselectPartType(Category categoryToClear);
    
    /**
     * reset the configuration
     */
    void clear();
    
    /**
     * @param stream
     */
	void printDescription(PrintStream stream);

}