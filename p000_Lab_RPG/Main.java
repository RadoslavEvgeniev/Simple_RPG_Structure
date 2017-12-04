package p000_Lab_RPG;

import p000_Lab_RPG.engine.Engine;
import p000_Lab_RPG.interfaces.Writer;
import p000_Lab_RPG.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        Runnable engine = new Engine(writer);

        engine.run();
    }
}
