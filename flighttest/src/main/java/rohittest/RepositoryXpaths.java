package rohittest;

public class RepositoryXpaths {
	public static class CitiesSelectionPage{
		public static String CityFromDropdown ="fromPort";
		public static String CityToDropdown ="toPort";
		public static String SearchFlightsButton ="//input[@class='btn btn-primary']";
		
	}
	public static class FlightSelectionPage{
		public static String FlightButton ="(//input[@class='btn btn-small'])[1]";
		
	}
	
	public static class DetailsPage{
		public static String PurchaseButton ="//input[@class='btn btn-primary']";
		
	}
	
	public static class ConfirmationPage{
		public static String ConfirmationMessage ="//div[@class='container']//h1[contains(text(),'Thank you for your purchase today!')]";
		
	}

}
