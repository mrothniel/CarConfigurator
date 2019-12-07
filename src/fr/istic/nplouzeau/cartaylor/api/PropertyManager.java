/**
 * 
 */
package fr.istic.nplouzeau.cartaylor.api;

import java.util.Optional;
import java.util.Set;

/**
 * @author Konan Kouassi Othniel
 * @author Fabrice KADIO
 *
 */
public interface PropertyManager {
	/**
	 * Returns an immutable set of the property names supported by the property manager.
	 * @return
	 */
	public Set<String> getPropertyNames();
	
	/**
	 * Return the immutable set of discrete String values for given property.
	 * For properties that have a non explicit set of values (eg double converted to string),
	 * or for for non existing property name, retunr an empty set.
	 * 
	 * @param propertyName a non-null string reference
	 * @return an immutable set (see above)
	 */
	public Set<String> getAvailablePropertyValues(String propertyName);
	
	/**
	 * Returns the optional value of a property.
	 * if the object does not support that property then optional is returned.
	 * @param propertyName the property to read
	 * @return
	 */
	public Optional<String> getProperty(String propertyName);
	
	/**
	 * Sets the value of a given property.
	 * if there is not such property, or if it not writable, or if the values is invalid
	 * then an IllegalArgumentException in thrown.
	 * @param propertyName
	 * @param propertyValues
	 * @throws IllegalArgumentException (see above)
	 */
	void setProperty(String propertyName, String propertyValues);
}
