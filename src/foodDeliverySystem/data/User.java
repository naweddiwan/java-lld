package foodDeliverySystem.data;

import lombok.Getter;

@Getter
public class User {
    private final int id;
    private final String name;
    private final Address address;
    private final String phoneNo;
    private final String email;

    public User(int id, String name, Address address, String phoneNo, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
}
