package ca.ubc.cs304.model;

public class AreaCode {
    private final String postalCode;
    private final String city;
    private final String province;

    public AreaCode(String postalCode, String city, String province) {
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }
}
