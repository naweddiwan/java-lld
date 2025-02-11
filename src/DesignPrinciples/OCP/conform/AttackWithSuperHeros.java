package DesignPrinciples.OCP.conform;

import java.util.List;

public class AttackWithSuperHeros {
    // Here we are dealing with abstract concept of superHero,
    // concrete implementation or objects are not handled here.
    void attackWithHeros(List<SuperHero> superHeroes) {
        for(SuperHero superHero: superHeroes){
            superHero.attack();
        }
    }
}
