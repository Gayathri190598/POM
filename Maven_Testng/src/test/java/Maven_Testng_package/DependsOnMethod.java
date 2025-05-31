package Maven_Testng_package;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	  @Test(priority = 1)
	  public void signUp() {
		  System.out.println("signUp");
	  }
	  @Test(dependsOnMethods = "signUp" , priority = -1)   //The dependOnMethod suppresses the priority and execute the test cases based on dependsOn only
	  public void login() {
		  System.out.println("login");
	  }
	  @Test(dependsOnMethods = "Maven_Testng_package.DependsOnMethod.login" ,description = "This method is used to search the product")
	  public void searchProduct() {
		  System.out.println("searchProduct");
	  }
	  @Test(dependsOnMethods = "searchProduct")
	  public void addToCart() {
	  System.out.println("addToCart");
		  throw new RuntimeException();
	  }
	  @Test(dependsOnMethods = "addToCart")
	  public void signOut() {
		  System.out.println("signUp");
  }
}
