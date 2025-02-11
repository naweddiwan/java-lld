package DesignPrinciples.OCP.conform;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(new SuperMan());
        AttackWithSuperHeros attackWithSuperHeros = new AttackWithSuperHeros();
        attackWithSuperHeros.attackWithHeros(superHeroes);
    }
}
