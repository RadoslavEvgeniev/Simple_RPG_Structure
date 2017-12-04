package p000_Lab_RPG.interfaces;

import p000_Lab_RPG.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);
    void setSuccessor(Handler successor);

}
