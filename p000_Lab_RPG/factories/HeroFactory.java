package p000_Lab_RPG.factories;

import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.models.Warrior;

public class HeroFactory {

    public HeroFactory(){}

    public static Warrior createWarrior(String name, int damage, Handler logger) {
        return new Warrior(name, damage, logger);
    }
}
