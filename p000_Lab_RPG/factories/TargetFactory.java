package p000_Lab_RPG.factories;

import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;
import p000_Lab_RPG.models.Dragon;

public class TargetFactory {

    public TargetFactory(){}

    public static ObservableTarget createTarget(String id, int hp, int reward, Handler logger) {
        return new Dragon(id, hp, reward, logger);
    }
}
