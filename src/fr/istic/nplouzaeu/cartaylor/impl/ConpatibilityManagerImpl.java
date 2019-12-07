package fr.istic.nplouzaeu.cartaylor.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ConpatibilityManagerImpl implements CompatibilityManager {
	
	private HashMap<PartType,HashSet<PartType>> imcompatibilitiesParts = new HashMap<PartType,HashSet<PartType>>();
	private HashMap<PartType,HashSet<PartType>> requirementsParts      = new HashMap<PartType,HashSet<PartType>>(); 
	
	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		Set<PartType> partValues = new HashSet<PartType>();
		if(reference != null) {
		    partValues = imcompatibilitiesParts.get(reference); 
		    if( partValues != null) {
		    	return new LinkedHashSet<PartType>(partValues); 
		    }
		}
		return new HashSet<PartType>();
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		Set<PartType> reqList = new HashSet<PartType>();
		if(reference != null) {
			reqList = requirementsParts.get(reference);
			if(reqList != null) {
				return new LinkedHashSet<PartType>(reqList);
			}
		}
		return  new LinkedHashSet<PartType>();
	}
	
	@Override
	public void addImcompatibilities(PartType reference, Set<PartType> target) {
		if(reference != null && target != null) {
			Set<PartType> reqList = new HashSet<PartType>();
			reqList = getRequirements(reference);
			Iterator<PartType> it = target.iterator();
			while(it.hasNext()) {
				PartType part = it.next();
				if( !reqList.contains(part) && !target.contains(reference) && !getRequirements(part).contains(reference)) {
					if(imcompatibilitiesParts.containsKey(reference)) {
						imcompatibilitiesParts.get(reference).add(part);
						if(imcompatibilitiesParts.containsKey(part)) {
							imcompatibilitiesParts.get(part).add(reference);
						}else {
							  Set<PartType> newPartList = new HashSet<PartType>();
							  imcompatibilitiesParts.put(part, (HashSet<PartType>) newPartList);
							  imcompatibilitiesParts.get(part).add(reference);
						}
					}else {
					    Set<PartType> newPartList = new HashSet<PartType>();
					    imcompatibilitiesParts.put(reference,  (HashSet<PartType>) newPartList);
					    imcompatibilitiesParts.get(reference).add(part);
						if(imcompatibilitiesParts.containsKey(part)) {
							imcompatibilitiesParts.get(part).add(reference);
						}else {
							  Set<PartType> partList = new HashSet<PartType>();
							  imcompatibilitiesParts.put(part, (HashSet<PartType>) partList);
							  imcompatibilitiesParts.get(part).add(reference);
						}
					}
				}else {
					Logger.getGlobal().log(Level.INFO, "impossible to add this Imcompatibilitie's list ");
				}
				
			}
		 }
			
		}

	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		if(reference != null && target != null) {
			if(imcompatibilitiesParts.containsKey(reference)) {
				Set<PartType> imcompatibilitiesPart1 =  getIncompatibilities(reference);
				if(imcompatibilitiesPart1.contains(target)) {
					imcompatibilitiesPart1.remove(target);
				}
				if(imcompatibilitiesParts.containsKey(target)) {
					Set<PartType> imcompatibilitiesPart2 = getIncompatibilities(target);
					if(imcompatibilitiesPart2.contains(reference)) {
						imcompatibilitiesPart1.remove(reference);
					}
				}
			}
		}
		

	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		if(reference != null && target != null) { 
			Set<PartType> imcList = new LinkedHashSet<PartType>();
			imcList = getIncompatibilities(reference);
			Iterator<PartType> it = target.iterator();
			while(it.hasNext()) {
				PartType part = it.next();
				if( !imcList.contains(part) && !target.contains(reference) && !getIncompatibilities(part).contains(reference)) {
					if(requirementsParts.containsKey(reference)) {
						requirementsParts.get(reference).add(part);
						if(requirementsParts.containsKey(part)) {
							requirementsParts.get(part).add(reference);
						}else {
							  Set<PartType> newPartList = new LinkedHashSet<PartType>();
							  requirementsParts.put(part,  (LinkedHashSet<PartType>) newPartList);
							  requirementsParts.get(part).add(reference);
						}
					}else {
					    Set<PartType> newPartList = new LinkedHashSet<PartType>();
						requirementsParts.put(reference,  (LinkedHashSet<PartType>) newPartList);
						requirementsParts.get(reference).add(part);
						if(requirementsParts.containsKey(part)) {
							requirementsParts.get(part).add(reference);
						}else {
							  Set<PartType> partList = new LinkedHashSet<PartType>();
							  requirementsParts.put(part,  (LinkedHashSet<PartType>) partList);
							  requirementsParts.get(part).add(reference);
						}
					}
				}else {
					Logger.getGlobal().log(Level.INFO, "impossible to add this Requirements's list ");
				}
				
			}
			
		}

	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		if(reference != null && target != null) {
			if(requirementsParts.containsKey(reference)) {
				Set<PartType> imcompatibilitiesPart1 =  requirementsParts.get(reference);
				if(imcompatibilitiesPart1.contains(target)) {
					imcompatibilitiesPart1.remove(target);
				}
				if(requirementsParts.containsKey(target)) {
					Set<PartType> imcompatibilitiesPart2 = requirementsParts.get(target);
					if(imcompatibilitiesPart2.contains(reference)) {
						imcompatibilitiesPart1.remove(reference);
					}
				}
			}
		}

	}

}
