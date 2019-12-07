package fr.istic.nplouzaeu.cartaylor.impl;

import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class CategoryImpl implements Category {
	

	private final String name;
	private  Set<PartType> partTypeList = new HashSet<PartType>();
	
	public CategoryImpl(String name) {
		this.name = name;
	}


	@Override
	public String getName() {
		return name;
	}
	
	@Override
	 public Set<PartType> getVariants(Set<PartType> list) {	
		for(PartType it : list) {
			if(it.getCategory() == this) partTypeList.add(it);
		}
		return partTypeList;
	}

}






