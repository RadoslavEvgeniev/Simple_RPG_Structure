package p000_Lab_RPG.loggers;

import p000_Lab_RPG.enums.LogType;
import p000_Lab_RPG.interfaces.Handler;
import p000_Lab_RPG.interfaces.Writer;

public abstract class Logger implements Handler {

    private Handler successor;
    private Writer writer;

    public Logger(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return this.writer;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }

    }

    public abstract void handle(LogType type, String message);
}
