package DesignPrinciples.OCP.conform;

public class SuperMan implements SuperHero {

    @Override
    public void attack() {
        System.out.println("Superman attacking");
    }
}
