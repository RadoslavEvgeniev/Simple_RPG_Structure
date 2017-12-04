package p000_Lab_RPG.interfaces;

import p000_Lab_RPG.interfaces.observer.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker attacker);
    void groupTarget(ObservableTarget target);
    void groupAttack();
}
