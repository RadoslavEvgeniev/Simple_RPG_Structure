package p000_Lab_RPG.mediator;

import p000_Lab_RPG.interfaces.AttackGroup;
import p000_Lab_RPG.interfaces.Attacker;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker attacker : attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackers) {
            attacker.attack();
        }
    }
}
