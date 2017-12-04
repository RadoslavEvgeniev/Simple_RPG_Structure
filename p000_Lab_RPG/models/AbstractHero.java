package p000_Lab_RPG.models;

import p000_Lab_RPG.enums.LogType;
import p000_Lab_RPG.interfaces.Attacker;
import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;
import p000_Lab_RPG.interfaces.observer.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "p000_Lab_RPG.interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Handler logger;

    public AbstractHero(String id, int dmg, Handler logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            if (this.target != null) {
                this.target.unregister(this);
            }
            this.target = target;
            target.register(this);
            this.logger.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg, this.logger);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    public void update(int value) {
        this.logger.handle(LogType.EVENT, String.format("%s gains %d exp", this.id, value));
    }

    protected abstract void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler logger);
}
