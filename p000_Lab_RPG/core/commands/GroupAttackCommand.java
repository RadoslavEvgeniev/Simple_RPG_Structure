package p000_Lab_RPG.core.commands;

import p000_Lab_RPG.core.BaseCommand;

public class GroupAttackCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getGroup().groupAttack();
    }
}
