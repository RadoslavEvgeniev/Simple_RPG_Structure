package p000_Lab_RPG.factories;

import p000_Lab_RPG.interfaces.AttackGroup;
import p000_Lab_RPG.mediator.Group;

public class GroupFactory {

    public GroupFactory(){}

    public static AttackGroup createParty() {
        return new Group();
    }
}
