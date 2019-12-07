
package fr.istic.nplouzaeu.cartaylor.impl;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityChecker;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Part;
import fr.istic.nplouzeau.cartaylor.api.PartType;
/**
 * @author Konan Kouassi Othniel
 * @author Fabrice Kadio
 */

public class ConfigurationImpl implements Configuration {
	
	
	private HashMap<Category, Part> config = new HashMap<Category,Part>();
	private CompatibilityChecker checker ; 
	 
	public ConfigurationImpl(CompatibilityChecker checker){
		this.checker = checker;
	}

	@Override
	public boolean isValid() {
			Objects.requireNonNull(getSelectedParts());
			for (Part it1 : getSelectedParts())
			{
				for(PartType it2 : checker.getIncompatibilities(it1.getType())) {
					
					for(Part it3 : getSelectedParts()) {
						if(it3.getType() == it2) return false ;		
					}
				}
				
				for(PartType it2 : checker.getRequirements(it1.getType())) {	
					for(Part it4 : getSelectedParts()) {
						if(it4.getType() != it2) return false ;
					}
				}
				
				
			}
		
		return true;
	}

	@Override
	public boolean isComplete() {
		if(config.size() == 4 ) return true ;
		else 
			return false ;
	}
	/**
	 *@implNote For each element contained in the HasMap <Category, Values> config.entryset() table
	 *we get the value of each pair we add to the parts
	 *parts is a collection of partType
	 *@return the collection of values for each category
	 */

	@Override
	public Set<Part> getSelectedParts() {
		Set<Part> parts = new HashSet<Part>();
			Objects.requireNonNull(config);
			for (HashMap.Entry<Category, Part> entry : config.entrySet())
				{
					parts.add((Part) entry.getValue()); 
					
				}
		  return new HashSet<Part>(parts) ; 
		}
	/**
	 * @param chosenPart variable of type PartType
	 * @implNote We check that a PartType is well selected and we add it 
	 * to the configuration but before we get the category to 
	 * which it belongs
	 */
	@Override
	public void selectPart(PartType chosenPartType) {
			Objects.requireNonNull(chosenPartType);
			Category partTypeCategory = chosenPartType.getCategory();
			PartTypeImpl part = (PartTypeImpl)chosenPartType ;
			config.put(partTypeCategory,part.newInstance());
	}
	/**
	 * @implNote If the selected 
	 * category exists then all the partType of this category is
	 * recovered.
	 *In clear we are looking for the partType that we for key the 
	 *name of the category
	 */
	@Override
	public Optional<Part> getSelectionForCategory(Category category) {
			Objects.requireNonNull(category);
			 return Optional.of(config.get(category)) ;
	}
	/**
	 * @implNote if the selected category exists in our Map then we can 
	 * override the category that automatically deletes these partType
	 */
	@Override
	public void unselectPartType(Category categoryToClear) {
			Objects.requireNonNull(categoryToClear);
			if(config.containsKey(categoryToClear)) {
				config.remove(categoryToClear);
		}
	}
	/**
	 * @implNote At the end of the configuration the config content is deleted
	 */
	@Override
	public void clear() {
		config.clear();
		// Logger.getGlobal().log(Level.INFO, "is clear: "+config.size());

	}
	
	@Override
	public void printDescription(PrintStream stream) {
		if(isValid() && isComplete()) {
			String htmlFileName = "CartTaylor_Configuration.html";
			try {
				stream= new PrintStream(htmlFileName);
				stream.println("<!DOCTYPE html>");
				stream.println("<html>");
				stream.println("<head>");
				stream.println("<title> Your Configuration</title>");
				stream.println("</head>");
				stream.println("<body>");
				for(Part it :  getSelectedParts() ) {
					it.printDescription(stream);
				}
				stream.println("</body>");
				stream.print("</html>");
				stream.flush();
				System.out.println("TCongratulations your configuration was well printed");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else if(isValid()){
			System.out.println("this configuration is not complete");
		}else {
			System.out.println("this configuration is not valid");
		}
	 }
	

}

