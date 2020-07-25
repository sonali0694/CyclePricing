package test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.calculate.price.CalculatePrice;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;



import junit.framework.TestCase;
import junit.framework.TestSuite;

class ModuleTest extends TestCase {

	
	    /**
	     * Create the test case
	     *
	     * @param testName name of the test case
	     */
	    public ModuleTest( String testName )
	    {
	        super( testName );
	    }

	    /**
	     * Rigourous Test :-)
	     */
	    public void testApp()
	    {
	    	CalculatePrice cp= new CalculatePrice();
	    	int result=0;
	    	try{
				int flag=cp.calculate();
				result=1;
				assertEquals("Result",result,flag);
				
			}
			catch (FileNotFoundException e) {
				   e.printStackTrace();
				  } catch (IOException e) {
				   e.printStackTrace();
				  } catch (ParseException e) {
				   e.printStackTrace();
				  }
					catch (java.text.ParseException e) {
					e.printStackTrace();
				}
	       // assertTrue( result );
	    }
	}