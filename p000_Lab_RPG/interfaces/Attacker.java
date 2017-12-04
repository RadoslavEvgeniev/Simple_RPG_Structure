package p000_Lab_RPG.interfaces;

import p000_Lab_RPG.interfaces.observer.ObservableTarget;

public interface Attacker {
    void attack();
    void setTarget(ObservableTarget target);
}
