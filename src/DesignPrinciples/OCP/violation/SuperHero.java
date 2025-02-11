package DesignPrinciples.OCP.violation;

public enum SuperHero {
    SUPER_MAN,
    BATMAN;

    void attackWithSuperMan() {
        System.out.println("Attack with SuperMan");
    }
    void attackWithBatman() {
        System.out.println("Attack with BatMan");
    }
}
