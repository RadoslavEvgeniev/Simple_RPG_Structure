package p000_Lab_RPG.factories;

import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.interfaces.Writer;
import p000_Lab_RPG.loggers.CombatLogger;
import p000_Lab_RPG.loggers.ErrorLogger;
import p000_Lab_RPG.loggers.EventLogger;
import p000_Lab_RPG.loggers.TargetLogger;

public class LoggerFactory {

    public LoggerFactory(){}

    public static Handler createLogger(String type, Writer writer) {
        switch (type) {
            case "combat":
                return new CombatLogger(writer);
            case "target":
                return new TargetLogger(writer);
            case "event":
                return new EventLogger(writer);
            case "error":
                return new ErrorLogger(writer);
        }
        return null;
    }
}
