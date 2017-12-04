package p000_Lab_RPG.core.commands;

import p000_Lab_RPG.core.BaseCommand;

public class AttackCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getAttacker().attack();
    }
}
