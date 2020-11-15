package ca.ubc.cs304.model;

public class AddressDestination {
    private final String houseNum;
    private final String postalCode;
    private final String street;
    private final String city;
    private final String province;

    public AddressDestination(String houseNum, String postalCode, String street,
                              String city, String province) {
        this.houseNum = houseNum;
        this.postalCode  = postalCode;
        this.street = street;
        this.city = city;
        this.province = province;
    }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }
}
