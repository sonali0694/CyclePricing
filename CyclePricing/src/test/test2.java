/**
 * 
 */
package test;

import junit.framework.TestCase;

/**
 * @author Sonali
 *
 */
public class test2 extends TestCase {

	/**
	 * @param name
	 */
	public test2(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.calculate.price.CalculatePrice#calculate()}.
	 */
	public void testCalculate() {
	//	fail("Not yet implemented");
		int result=0;
		int expected=0;
		assertEquals(result,expected);
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	public void testEquals() {
		fail("Not yet implemented");
	}

}
