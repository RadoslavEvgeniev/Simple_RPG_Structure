package p000_Lab_RPG.core;

import p000_Lab_RPG.annotations.Inject;
import p000_Lab_RPG.interfaces.*;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;

public abstract class BaseCommand implements Command {

    @Inject
    private Attacker attacker;
    @Inject
    private ObservableTarget target;
    @Inject
    private AttackGroup group;

    protected BaseCommand(){}

    public Attacker getAttacker() {
        return this.attacker;
    }

    public ObservableTarget getTarget() {
        return this.target;
    }

    public AttackGroup getGroup() {
        return this.group;
    }
}
