/**
 * 
 */
package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author admn
 *
 */


public class TestNG_Demo {

		
	@BeforeMethod
	public void test1() {

		System.out.println("===============I am in Before Method==========");
	}

	@AfterMethod
	public void test2() {

		System.out.println("===============I am in after Method==========");
	}

	@BeforeSuite
	public void test3() {

		System.out.println("===============I am in Before suite==========");
	}

	@AfterSuite
	public void test4() {

		System.out.println("===============I am in Before suite==========");
	}
	
	@BeforeTest
	public void test5() {

		System.out.println("===============I am in Before test==========");
	}
	
	@AfterTest
	public void test6(){
		
		System.out.println("===============I am in after test==========");
	}
	

	@Test
	public void test7(){
		
		System.out.println("===============I am in  test==========");
	}
	
	@Test
	public void test8(){
		

		System.out.println("===============I am in  second test==========");
	}
	
	
	
	
	
}
