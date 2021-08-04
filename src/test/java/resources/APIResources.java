package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),	
	UpdatePlaceAPI("/maps/api/place/update/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	getPlaceAPI("/maps/api/place/get/json");
	private String resource;

	APIResources(String string) {
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}
	

}
