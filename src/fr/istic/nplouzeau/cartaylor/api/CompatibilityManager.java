package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityManager extends CompatibilityChecker {
	
	/**
	 * 
	 * @param reference is the piece selected by the user
	 * @param target is the list of incompatible parts relating to the selected piece
	 * @throws Exception 
	 */
    void addImcompatibilities(PartType reference, Set<PartType> target) throws Exception;

    /**
     * 
     * @param reference is the piece selected by the user
     * @param target is the piece to remove incompatible parts
     */
    void removeIncompatibility(PartType reference, PartType target);
    

	/**
	 * 
	 * @param reference is the piece selected by the user
	 * @param target is the list of required parts for the selected piece
	 */

    void addRequirements(PartType reference, Set<PartType> target);

    /**
     * 
     * @param reference is the piece selected by the user
     * @param target is the piece to be removed from the list of required parts
     */
    
    void removeRequirement(PartType reference, PartType target);

}
