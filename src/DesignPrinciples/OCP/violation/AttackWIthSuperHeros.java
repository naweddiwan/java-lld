package DesignPrinciples.OCP.violation;
import java.util.List;

public class AttackWIthSuperHeros {
    void attackWithHeros(List<SuperHero> superHeroes) {
        // Violates OCP as when we add new superhero,
        // we will need to add one more case
        for(SuperHero superHero: superHeroes) {
            switch (superHero) {
                case SUPER_MAN -> superHero.attackWithSuperMan();
                case BATMAN -> superHero.attackWithBatman();
                default -> System.out.println("UNKOWN SUPERHERO");
            }
        }
    }
}
