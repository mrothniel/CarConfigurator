package fr.istic.nplouzaeu.cartaylor.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.istic.nplouzaeu.cartaylor.Parts.EG100;
import fr.istic.nplouzaeu.cartaylor.Parts.IN;
import fr.istic.nplouzaeu.cartaylor.Parts.TM5;
import fr.istic.nplouzaeu.cartaylor.Parts.XC;
import fr.istic.nplouzaeu.cartaylor.impl.ConfiguratorImpl;
import fr.istic.nplouzaeu.cartaylor.impl.ConpatibilityManagerImpl;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityChecker;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.Part;
import fr.istic.nplouzeau.cartaylor.api.PartType;

/**
 * @author Konan Kouassi Othniel
 * @author Kadio Fabrice
 *
 */
class Test2 {
	
	Configurator configurator ;
	 CompatibilityManager manager ;
    // Configurator checker ;
    Configuration configuration ;
    Set<Category> categoryList ;
    Category engine , transmission, exterior, interior;
    Set<PartType> enginePartTypeList, transmissionPartTypeList, exteriorPartTypeList, interiorPartTypeList; 
    CompatibilityChecker getCompatibilitiesChecker ;
	/**
	 * 
	 * @param categoryName
	 * @param catList
	 * @return La categorie dans la liste de toute les categories
	 */
	public static Category selectCategoryInList(String categoryName, Set<Category> catList) {
		
		 for ( Category e: catList){
			if(e.getName().equals(categoryName)) {
				return e;
			}
		  }
		return null;
	}
	/**
	 * 
	 * @param partName
	 * @param partList
	 * @return une partType de la liste des partTypes
	 */
	public static PartType selectPartTypeInList(String partName, Set<PartType> partList) {
		
		 for ( PartType e: partList){
			if(e.getName().equals(partName)) {
				return e;
			}
		  }
		return null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		manager = new ConpatibilityManagerImpl();
		configurator  = new ConfiguratorImpl();
		configuration = configurator.getConfiguration();
		categoryList = configurator.getCategories();
		engine       = selectCategoryInList("Engine",categoryList);
		exterior     = selectCategoryInList("Exterior",categoryList);
		interior     = selectCategoryInList("Interior",categoryList);
		transmission = selectCategoryInList("Transmission",categoryList);
		enginePartTypeList = configurator.getVariants(engine);
		transmissionPartTypeList = configurator.getVariants(transmission);
		exteriorPartTypeList = configurator.getVariants(exterior);
		interiorPartTypeList = configurator.getVariants(interior);
		getCompatibilitiesChecker = configurator.getCompatibilityChecker();
		
		    
	}

	@Test
	@DisplayName("check if all the parts have been properly initialized in the configuration ")
	void testinit() {
		 Set<PartType> list = new HashSet<PartType>();
		 list.addAll(enginePartTypeList);
		 list.addAll(exteriorPartTypeList);
		 list.addAll(interiorPartTypeList);
		 list.addAll(transmissionPartTypeList);
		 assertEquals(list.size(),18);
	}
	@Test
	@DisplayName("check if selectCategoryInList return the categories which are in the configuration ")
	void test() {
		 assertEquals(categoryList.size() , 4);
		 assertTrue(categoryList.contains(engine));
		 assertTrue(categoryList.contains(exterior));
		 assertTrue(categoryList.contains(interior));
		 assertTrue(categoryList.contains(transmission));
	}
	
	@Test
	@DisplayName("check if the list of parttType is not null ")
	void test2() {
		assertNotNull(enginePartTypeList);
		assertNotNull(transmissionPartTypeList);
		assertNotNull(exteriorPartTypeList);
		assertNotNull(interiorPartTypeList);
	}
	
	@Test
	@DisplayName("check if all interior's partType are contents in interior partTypeList ")
	void test3() {
		Set<PartType> list1 = new HashSet<PartType>();
		PartType p1 = selectPartTypeInList("IN", interiorPartTypeList);
		PartType p2 = selectPartTypeInList("IH", interiorPartTypeList);
		PartType p3 = selectPartTypeInList("IS", interiorPartTypeList);
		list1.add(p1);
		list1.add(p2);
		list1.add(p3);
		assertEquals(p1.getName(), "IN");
		assertEquals(p2.getName(), "IH");
		assertEquals(p3.getName(), "IS");
		assertTrue(list1.containsAll(interiorPartTypeList));
	}
	
	@Test
	@DisplayName("check if XC is incompatible with EG210 ")
	void test4() {
		PartType xc      				 = selectPartTypeInList("XC", exteriorPartTypeList);
		PartType eg210    				 = selectPartTypeInList("EG210", enginePartTypeList);
		Set<PartType> xcImcompatibleList = getCompatibilitiesChecker.getIncompatibilities(xc);
		assertTrue(xcImcompatibleList.contains(eg210));
	}
	
	@Test
	@DisplayName("check if IS and XS are required in both directions")
	void test5() {
		PartType is      				= selectPartTypeInList("IS", interiorPartTypeList);
		PartType xs      				= selectPartTypeInList("XS", exteriorPartTypeList);
		Set<PartType> isRequirementList = getCompatibilitiesChecker.getRequirements(is);
		Set<PartType> xSRequirementList = getCompatibilitiesChecker.getRequirements(xs);
	    assertTrue(isRequirementList.contains(xs));
		assertTrue(xSRequirementList.contains(is));
	}
	
	@Test
	@DisplayName("remove eg100 in tsf7 incompatibilities list")
	void test6() {
		PartType eg100      			= selectPartTypeInList("EG100", enginePartTypeList);
		PartType tsf7      				= selectPartTypeInList("TSF7", transmissionPartTypeList);
		Set<PartType> tsf7ImcompatibleList = manager.getIncompatibilities(tsf7);
		manager.removeIncompatibility(tsf7,eg100);
	    assertFalse(tsf7ImcompatibleList.contains(eg100));
	}
	
	@Test
	@DisplayName("remove is in xs requirement list")
	void test7() {
		PartType is      			    = selectPartTypeInList("IS",interiorPartTypeList);
		 PartType xs     				= selectPartTypeInList("XS", exteriorPartTypeList);
		Set<PartType> isReqList = manager.getRequirements(is);
		Set<PartType> xsReqList = manager.getRequirements(xs);
		manager.removeRequirement(is, xs);
	    assertFalse(isReqList.contains(xs));
	    assertFalse(xsReqList.contains(is));
	}
	    
	    @Test 
	   	@DisplayName("test a valid and complete configuration v1")
	       void test8() {
	    	PartType eg100   = selectPartTypeInList("EG100", enginePartTypeList);
			PartType tm5     = selectPartTypeInList("TM5",   transmissionPartTypeList);
			PartType xc      = selectPartTypeInList("XC",    exteriorPartTypeList);
			configuration.selectPart(eg100);
	    	configuration.selectPart(tm5); 
	    	configuration.selectPart(xc);
	    	assertFalse(configuration.isComplete());
	    	assertTrue(configuration.isValid());
	    	PartType ih      = selectPartTypeInList("IH",    interiorPartTypeList);
	    	configuration.selectPart(ih);
	    	assertTrue(configuration.isComplete());
	    	   
	       }
	    
	    @Test 
	   	@DisplayName("test a valid and complete configuration v2 with incompatibilities partType in configuration")
	       void test9() {
	    	PartType eg100     = selectPartTypeInList("EG100", enginePartTypeList);
			PartType ta5       = selectPartTypeInList("TA5",   transmissionPartTypeList);
			PartType xc        = selectPartTypeInList("XC",    exteriorPartTypeList);
			PartType ih      = selectPartTypeInList("IH",    interiorPartTypeList);
			configuration.selectPart(ih);
			configuration.selectPart(eg100);
	    	configuration.selectPart(ta5); 
	    	configuration.selectPart(xc);
	    	assertFalse(configuration.isValid());
	    	assertTrue(configuration.isComplete());
	    	configuration.unselectPartType(engine);
	    	assertFalse(configuration.isComplete());
	    	assertTrue(configuration.isValid());
	    	   
	       }
	    
	    @Test 
	   	@DisplayName("Print Description for a valide and complete configuration")
	       void test10() {
	    	PartType eg100   = selectPartTypeInList("EG100", enginePartTypeList);
			PartType tm5     = selectPartTypeInList("TM5",   transmissionPartTypeList);
			PartType xc      = selectPartTypeInList("XC",    exteriorPartTypeList);
			configuration.selectPart(eg100);
	    	configuration.selectPart(tm5); 
	    	configuration.selectPart(xc);
	    	PartType ih      = selectPartTypeInList("IH",    interiorPartTypeList);
	    	configuration.selectPart(ih);
	    	assertTrue(configuration.isValid());
	    	configuration.printDescription(System.out);
	    	   
	       }
	    
	    @Test 
	   	@DisplayName("Check if a part is a type of partType and simulation complete")
	    public void test11() {
		    PartType eg100  =  selectPartTypeInList("EG100", enginePartTypeList);
		    assertNotNull(eg100);
		    PartType tm5    =  selectPartTypeInList("TM5", transmissionPartTypeList);
		    assertNotNull(tm5);
		    PartType xc     =  selectPartTypeInList("XC",  exteriorPartTypeList);
		    assertNotNull(xc);
		    PartType in     = selectPartTypeInList("IN", interiorPartTypeList);
		    assertNotNull(in);
			configuration.selectPart(eg100);
			Optional<Part> eg100Part = configuration.getSelectionForCategory(engine);
			assertTrue(eg100Part.get() instanceof EG100);
			configuration.selectPart(tm5);
			Optional<Part> tm5Part = configuration.getSelectionForCategory(transmission);
			assertTrue(tm5Part.get() instanceof TM5);
			configuration.selectPart(xc);
			Optional<Part> xcPart = configuration.getSelectionForCategory(exterior);
			assertTrue(xcPart.get() instanceof XC);
			configuration.selectPart(in);
			Optional<Part> inPart = configuration.getSelectionForCategory(interior);
			assertTrue(inPart.get() instanceof IN);
			Set<Part> parts = configuration.getSelectedParts();
			assertNotNull( parts);
			assertEquals(parts.size(), 4);
			assertTrue(configuration.isValid());
			assertTrue(configuration.isComplete());
			Set<PartType> eg100IcompList = new HashSet<PartType>();
			eg100IcompList.add(tm5);
			try {
				((CompatibilityManager) getCompatibilitiesChecker).addImcompatibilities(eg100, eg100IcompList);
				 manager.addImcompatibilities(eg100, eg100IcompList);
			}catch (Exception e) {}
			
		    assertFalse(configuration.isValid());
		    configuration.unselectPartType(engine);
			assertFalse(configuration.isComplete());
 			PartType eg133 =  selectPartTypeInList("EG133", enginePartTypeList);
			configuration.selectPart(eg133);	
			assertTrue(configuration.isComplete());
			configuration.clear();
			assertTrue(configuration.getSelectedParts().isEmpty());
		}
	    
	    @Test 
	   	@DisplayName("Remove a part ")
	    public void test12() {
	    	PartType ta5   = selectPartTypeInList("TA5",   transmissionPartTypeList);
	    	assertNotNull(ta5);
	    	configuration.selectPart(ta5);
	    	Optional <Part> p = configuration.getSelectionForCategory(transmission);
	    	configuration.unselectPartType(transmission);
	    	assertFalse(configuration.getSelectedParts().contains(p.get()));
	    }
	    
	    @Test 
	   	@DisplayName("check the properties of the parts XS ")
	    public void test13() {
	    	PartType xs = selectPartTypeInList("XS", exteriorPartTypeList);
	    	configuration.selectPart(xs);
	    	Optional <Part> p1 = configuration.getSelectionForCategory(exterior);
	    	assertNotNull(p1);
	    	// get property name for this part
	    	Set<String> xsPropertyNames = p1.get().getPropertyNames();
	    	// check if color is a property in this part
	    	assertTrue( xsPropertyNames.contains("color"));
	    	// check if price is a property in this part
	    	assertTrue( xsPropertyNames.contains("price"));
	    	// check if a color is present in this part
	    	Optional<String> colorValues = p1.get().getProperty("color");
	    	assertTrue(colorValues.isPresent());
	    	// check the different property values for this part
	    	Set<String> possiblesValues = p1.get().getAvailablePropertyValues("color");
	    	assertTrue(possiblesValues.contains("Red"));
	    	assertTrue(possiblesValues.contains("White"));
	    	assertTrue(possiblesValues.contains("Blue"));
	    	assertFalse(possiblesValues.contains("Green"));
	    	// check the color which is selected
	    	assertEquals(colorValues.get(),"Blue");
	    	
	    }
	    
	    @Test 
	   	@DisplayName("check the properties of the parts XC ")
	    public void test14() {
	    	PartType xc = selectPartTypeInList("XC", exteriorPartTypeList);
	    	configuration.selectPart(xc);
	    	Optional <Part> p1 = configuration.getSelectionForCategory(exterior);
	    	assertNotNull(p1);
	    	// get property name for this part
	    	Set<String> xcPropertyNames = p1.get().getPropertyNames();
	    	// check if color is a property in this part
	    	assertTrue( xcPropertyNames.contains("color"));
	    	// check if price is a property in this part
	    	assertTrue( xcPropertyNames.contains("price"));
	    	// check if a price is present in this part
	    	Optional<String> price = p1.get().getProperty("price");
//	    	System.out.println(price);
	    	// check the price
	    	assertEquals(price.get(),"200.0");
	    	
	    	
	    	
	    }
}