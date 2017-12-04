package p000_Lab_RPG.loggers;

import p000_Lab_RPG.enums.LogType;
import p000_Lab_RPG.interfaces.Writer;

public class TargetLogger extends Logger {

    public TargetLogger(Writer writer) {
        super(writer);
    }

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.TARGET) {
            super.getWriter().writeLine(type + " : " + message);
        }
        super.passToSuccessor(type, message);
    }
}
