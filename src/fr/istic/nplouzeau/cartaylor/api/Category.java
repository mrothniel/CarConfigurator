package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

/**
 * @author plouzeau
 * <p>
 * A public type to organize part types in categories
 */
public interface Category {

    String getName();
     /**
      * 
      * @param parts
      */
    public Set<PartType> getVariants(Set<PartType> list);

}
