package p000_Lab_RPG.engine;

import p000_Lab_RPG.annotations.Inject;
import p000_Lab_RPG.factories.GroupFactory;
import p000_Lab_RPG.factories.HeroFactory;
import p000_Lab_RPG.factories.LoggerFactory;
import p000_Lab_RPG.factories.TargetFactory;
import p000_Lab_RPG.interfaces.*;
import p000_Lab_RPG.interfaces.observer.ObservableTarget;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Writer writer;
    private Attacker attacker;
    private ObservableTarget target;
    private AttackGroup group;

    public Engine(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        Handler combatLogger = LoggerFactory.createLogger("combat", this.writer);
        Handler targetLogger = LoggerFactory.createLogger("target", this.writer);
        Handler errorLogger = LoggerFactory.createLogger("error", this.writer);
        Handler eventLogger = LoggerFactory.createLogger("event", this.writer);

        combatLogger.setSuccessor(targetLogger);
        targetLogger.setSuccessor(eventLogger);
        eventLogger.setSuccessor(errorLogger);

        this.attacker = HeroFactory.createWarrior("Gosho", 10, combatLogger);
        this.target = TargetFactory.createTarget("Miro", 5, 100, combatLogger);

        try {
            dispatchCommand("TargetCommand");
            dispatchCommand("AttackCommand");
            dispatchCommand("AttackCommand");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        this.group = GroupFactory.createParty();
        this.group.addMember(HeroFactory.createWarrior("Pesho", 10, combatLogger));
        this.group.addMember(HeroFactory.createWarrior("Gosho", 10, combatLogger));
        this.group.addMember(HeroFactory.createWarrior("Tosho", 10, combatLogger));
        this.target = TargetFactory.createTarget("Ivan", 40, 100, combatLogger);

        try {
            dispatchCommand("GroupTargetCommand");
            dispatchCommand("GroupAttackCommand");
            dispatchCommand("GroupAttackCommand");
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void dispatchCommand(String command) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Command> commandClass = (Class<Command>) Class.forName("p000_Lab_RPG.core.commands." + command);
        Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor();
        Command commandInstance = commandConstructor.newInstance();
        inject(commandInstance);
        commandInstance.execute();
    }

    private void inject(Command commandInstance) throws IllegalAccessException {
        Field[] commandFields = commandInstance.getClass().getSuperclass().getDeclaredFields();
        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)) {
                Field[] thisFields = this.getClass().getDeclaredFields();
                for (Field thisField : thisFields) {
                    if (commandField.getType().equals(thisField.getType())) {
                        commandField.setAccessible(true);
                        commandField.set(commandInstance, thisField.get(this));
                    }
                }
            }
        }
    }
}
