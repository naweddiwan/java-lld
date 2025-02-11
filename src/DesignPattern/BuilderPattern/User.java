package DesignPattern.BuilderPattern;

public class User {
    private final int id;
    private final String name;
    private final String phoneNumber;
    private final int age;

    // This class is private so that no one can call the constructor.
    private User(Builder builder ) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
    }

    // Static builder class so that it associated with the class
    public static class Builder {
        private final int id;
        private final String name;
        private String phoneNumber;
        private int age;
        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
