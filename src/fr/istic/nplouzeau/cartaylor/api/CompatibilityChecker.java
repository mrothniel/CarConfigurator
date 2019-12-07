package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityChecker {
	/**
	 * 
	 * @param reference a PartType part
	 * @return return a collection of incompatibility of a piece passes in parameter
	 */

    Set<PartType> getIncompatibilities(PartType reference);
    
    /**
	 * 
	 * @param reference the piece in question
	 * @return return a collection of the required pieces with this piece
	 */
    Set<PartType> getRequirements(PartType reference);

}
