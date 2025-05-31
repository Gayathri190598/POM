package Maven_Testng_package;

import org.testng.annotations.Test;

public class LearnAttributes {
	//PRIORITY PARAMETER
	
  @Test(priority = 1)
  public void signUp() {
	  System.out.println("signUp");
  }
  @Test(priority = 2)
  public void login() {
	  System.out.println("login");
  }
  @Test(priority = 3)
  public void searchProduct() {
	  System.out.println("searchProduct");
  }
  @Test(priority = 4)
  public void addToCart() {
	  System.out.println("addToCart");
  }
  @Test(priority = 5)
  public void signOut() {
	  System.out.println("signUp");
  }
}
