package p000_Lab_RPG.loggers;

import p000_Lab_RPG.enums.LogType;
import p000_Lab_RPG.interfaces.Writer;

public class EventLogger extends Logger {

    public EventLogger(Writer writer) {
        super(writer);
    }

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT) {
            super.getWriter().writeLine(type + " : " + message);
        }

        super.passToSuccessor(type, message);
    }
}
