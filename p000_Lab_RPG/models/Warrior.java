package p000_Lab_RPG.models;

import p000_Lab_RPG.enums.LogType;
import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler logger) {
        logger.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }


}
