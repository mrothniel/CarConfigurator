package fr.istic.nplouzaeu.cartaylor.impl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fr.istic.nplouzaeu.cartaylor.Parts.ED110;
import fr.istic.nplouzaeu.cartaylor.Parts.ED180;
import fr.istic.nplouzaeu.cartaylor.Parts.EG100;
import fr.istic.nplouzaeu.cartaylor.Parts.EG133;
import fr.istic.nplouzaeu.cartaylor.Parts.EG210;
import fr.istic.nplouzaeu.cartaylor.Parts.EH120;
import fr.istic.nplouzaeu.cartaylor.Parts.IH;
import fr.istic.nplouzaeu.cartaylor.Parts.IN;
import fr.istic.nplouzaeu.cartaylor.Parts.IS;
import fr.istic.nplouzaeu.cartaylor.Parts.TA5;
import fr.istic.nplouzaeu.cartaylor.Parts.TC120;
import fr.istic.nplouzaeu.cartaylor.Parts.TM5;
import fr.istic.nplouzaeu.cartaylor.Parts.TM6;
import fr.istic.nplouzaeu.cartaylor.Parts.TS6;
import fr.istic.nplouzaeu.cartaylor.Parts.TSF7;
import fr.istic.nplouzaeu.cartaylor.Parts.XC;
import fr.istic.nplouzaeu.cartaylor.Parts.XM;
import fr.istic.nplouzaeu.cartaylor.Parts.XS;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityChecker;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ConfiguratorImpl implements Configurator {
	
	private CompatibilityChecker check ;
	private Configuration config ;
	private Set<Category> categories ;
	private Set<PartType> partTypes ;
	    
	    public ConfiguratorImpl() {
	    	categories = new HashSet<Category>();
	    	partTypes = new HashSet<PartType>();
	    	Category engine = new CategoryImpl("Engine");
	    	Category transmission = new CategoryImpl("Transmission");
	    	Category exterior = new CategoryImpl("Exterior");
	    	Category interior = new CategoryImpl("Interior");
	    	categories.add(interior);
	    	categories.add(exterior);
	    	categories.add(engine);
	    	categories.add(transmission);
	    	
	    	PartType eg100 = new PartTypeImpl(engine, "EG100", EG100.class);
	    	PartType eg133 = new PartTypeImpl( engine, "EG133", EG133.class);
	    	PartType eg210 = new PartTypeImpl( engine, "EG210", EG210.class);
	    	PartType ed110 = new PartTypeImpl(engine, "ED110", ED110.class);
	    	PartType ed180 = new PartTypeImpl( engine, "ED180", ED180.class);
	    	PartType eh120 = new PartTypeImpl( engine, "EH120", EH120.class);
	    	
	    	
	    	PartType tm5   = new PartTypeImpl(transmission,"TM5",TM5.class);
	    	PartType tm6   = new PartTypeImpl(transmission, "TM6", TM6.class);
	    	PartType ta5   = new PartTypeImpl(transmission, "TA5",TA5.class);
	    	PartType ts6   = new PartTypeImpl(transmission, "TS6", TS6.class);
	    	PartType tsf7  = new PartTypeImpl(transmission, "TSF7", TSF7.class);
	    	PartType tc120 = new PartTypeImpl(transmission, "TC120", TC120.class);
	    	
	    	PartType xm = new PartTypeImpl(exterior, "XM", XM.class);
	    	PartType xs = new PartTypeImpl(exterior, "XS", XS.class);
	    	PartType xc = new PartTypeImpl(exterior, "XC", XC.class);
	    	
	    	PartType in = new PartTypeImpl(interior, "IN", IN.class);
	    	PartType ih = new PartTypeImpl(interior, "IH", IH.class);
	    	PartType is = new PartTypeImpl(interior, "IS", IS.class);
	    	
	    	partTypes.add(eh120);
	    	partTypes.add(ed180);
	    	partTypes.add(ed110);
	    	partTypes.add(eg210);
	    	partTypes.add(eg100);
	    	partTypes.add(eg133);
	    	partTypes.add(is);
	    	partTypes.add(ih);
	    	partTypes.add(in);
	    	partTypes.add(xc);
	    	partTypes.add(xs);
	    	partTypes.add(xm);
	    	partTypes.add(tc120);
	    	partTypes.add(tsf7);
	    	partTypes.add(ts6);
	    	partTypes.add(ta5);
	    	partTypes.add(tm6);
	    	partTypes.add(tm5);
	    	check = new  ConpatibilityManagerImpl();
	         // add default imcompatibilities in this configuration
		    Set<PartType> ta5ImcompList = new HashSet<PartType>();
			Set<PartType> tsf7ImcompList = new HashSet<PartType>();
			Set<PartType> xcImcompList = new HashSet<PartType>();
			Set<PartType> xmImcompList = new HashSet<PartType>();
			Set<PartType> xsImcompList = new HashSet<PartType>();
			Set<PartType> isImcompList = new HashSet<PartType>();
			ta5ImcompList.add(eg100);
			tsf7ImcompList.add(eg100);
			tsf7ImcompList.add(eg133);
			tsf7ImcompList.add(ed110);
			xcImcompList.add(eg210);
			xmImcompList.add(eg100);
			xsImcompList.add(eg100);
			isImcompList.add(eg100);
			isImcompList.add(eg100);
	    	ta5ImcompList.add(eg100);
	    	try {
				((CompatibilityManager) check).addImcompatibilities(ta5,ta5ImcompList);
				((CompatibilityManager) check).addImcompatibilities(tsf7,tsf7ImcompList);
				((CompatibilityManager) check).addImcompatibilities(xc , xcImcompList);
				((CompatibilityManager) check).addImcompatibilities(xm,xmImcompList);
				((CompatibilityManager) check).addImcompatibilities(xs,xsImcompList);
				((CompatibilityManager) check).addImcompatibilities(is,isImcompList);
			} catch (Exception e) {
				e.printStackTrace();
			}
	         // add default requirement in this configuration
	    	 Set<PartType> tc120RequirmentList = new HashSet<PartType>();
	    	 Set<PartType> xsRequirmentList = new HashSet<PartType>();
	    	 tc120RequirmentList.add(eh120);
	    	 xsRequirmentList.add(is);
	    	 ((CompatibilityManager) check).addRequirements(tc120,tc120RequirmentList);
	    	 ((CompatibilityManager) check).addRequirements(xs,xsRequirmentList);
	    	 
	    	 config = new ConfigurationImpl(check);
	    	
	    	
	    }

	@Override
	public Set<Category> getCategories() {
		return categories;
	}

	 @Override
	public Set<PartType> getVariants(Category category) {
		    Objects.requireNonNull(category);
			Set<PartType> parts = new HashSet<PartType>();
			CategoryImpl categorie = (CategoryImpl)category ;
			parts =  categorie.getVariants(partTypes);
			return new HashSet<PartType>(parts);
	}

	@Override
	public Configuration getConfiguration() {
		return config ;
	}

	@Override
	public CompatibilityChecker getCompatibilityChecker() {
		return check;
		
	}
	
}
