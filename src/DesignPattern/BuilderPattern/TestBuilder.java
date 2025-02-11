package DesignPattern.BuilderPattern;

public class TestBuilder {
    public static void main(String[] args) {
        User u1 =  new User.Builder(1, "nawed").setPhoneNumber("1231231").setAge(123).build();
        System.out.println(u1.getId());
        System.out.println(u1.getName());
        System.out.println(u1.getAge());
        System.out.println(u1.getPhoneNumber());
    }
}
