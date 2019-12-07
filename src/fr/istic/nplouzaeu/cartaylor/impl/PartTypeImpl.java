package fr.istic.nplouzaeu.cartaylor.impl;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class PartTypeImpl implements PartType {
	
	private Category category ;
	private String name ;
	private String description;
	private Class<? extends PartImpl> classRef;
	
	public PartTypeImpl(Category category, String name, Class<? extends PartImpl> classRef) {
		//super();
		this.category = category;
		this.name = name;
		this.classRef = classRef;
	}
	

	public PartImpl newInstance() {
		Constructor<? extends PartImpl> constructor;
		try {
		constructor = classRef.getConstructor(PartType.class);
		return constructor.newInstance(this);
		}catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE,"constructor call failled", e);
			System.exit(-1);
		}
		return null;
	}


	@Override
	public Category getCategory() {

		return category;
	}

	@Override
	public String getName() {
		return this.name ;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

}
