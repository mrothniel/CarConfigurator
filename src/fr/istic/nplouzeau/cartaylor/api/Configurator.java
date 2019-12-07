package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;



public interface Configurator {
	  /**
     * 
     * @return a collection of categories that the app can offer
     */
	Set<Category> getCategories();
	 /**
	   * 
	   * @param category will be used as a key to find PartType variants
	   * @return a PartType collection that category c can offer
	   */
	
    Set<PartType> getVariants(Category category);
    /**
	 * 
	 * @return the current configuration
	 */

    Configuration getConfiguration();
    /**
   	 * 
   	 * @return the list of compatible and uncompatible parts of the configuration
   	 */
    CompatibilityChecker getCompatibilityChecker();

}