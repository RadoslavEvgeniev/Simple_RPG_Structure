package p000_Lab_RPG.io;

import p000_Lab_RPG.interfaces.Writer;

public class ConsoleWriter implements Writer {

    public void writeLine(String line) {
        System.out.println(line);
    }
}
