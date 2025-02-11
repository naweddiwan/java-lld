package DesignPrinciples.OCP.violation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SuperHero> superHeroList = new ArrayList<>();
        superHeroList.add(SuperHero.SUPER_MAN);
        superHeroList.add(SuperHero.BATMAN);

        AttackWIthSuperHeros attackWIthSuperHeros = new AttackWIthSuperHeros();
        attackWIthSuperHeros.attackWithHeros(superHeroList);
    }

}
