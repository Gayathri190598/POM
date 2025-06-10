package pageObjects;

import utilities.DriverManager;

public class PageTitle {
	
private static PageTitle pageTitleInstance;
	
	private PageTitle() {
	
	}
	
	public static PageTitle getInstance() {
		if(pageTitleInstance==null) {
			pageTitleInstance=new PageTitle();
		}
		return pageTitleInstance;
	}
	
	
	
	 public String getPageTitle() {
		 return DriverManager.getDriver().getTitle();
	 }


}
