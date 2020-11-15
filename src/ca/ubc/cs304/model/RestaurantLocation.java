package ca.ubc.cs304.model;

public class RestaurantLocation {
    private final String street;
    private final String unitNum;
    private final String postalCode;

    public RestaurantLocation(String street, String unitNum, String postalCode) {
        this.street = street;
        this.unitNum = unitNum;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getUnitNum() {
        return this.unitNum;
    }

    public String getPostalCode() {
        return this.postalCode;
    }
}
