package p000_Lab_RPG.core.commands;

import p000_Lab_RPG.core.BaseCommand;

public class GroupTargetCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getGroup().groupTarget(super.getTarget());
    }
}
