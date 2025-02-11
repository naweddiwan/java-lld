package foodDeliverySystem.data;

import lombok.Getter;

@Getter
public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public Address(String addressLine1, String addressLine2, String addressLine3, String city, String state, String zip, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
