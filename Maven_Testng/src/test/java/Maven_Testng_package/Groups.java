package Maven_Testng_package;

import org.testng.annotations.Test;

public class Groups {
	  @Test(groups = {"smoke"})
	  public void signUp() {
		  System.out.println("signUp");
	  }
	  @Test(groups = {"reg"})
	  public void login() {
		  System.out.println("login");
	  }
	  @Test(groups = {"sanity"})
	  public void searchProduct() {
		  System.out.println("searchProduct");
	  }
	  @Test(groups = {"smoke"})
	  public void addToCart() {
		  System.out.println("addToCart");
	  }
	  @Test(groups = {"reg"})
	  public void signOut() {
		  System.out.println("signUp");
	  }
}
