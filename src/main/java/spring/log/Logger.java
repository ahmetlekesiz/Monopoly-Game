package spring.log;

import Controller.Main;

import java.io.IOException;
import java.util.logging.*;

public class Logger {

    public static final Logger instance = new Logger();
    public final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Main.class.getName());
    public static final Level DEFAULT_LEVEL = Level.INFO;

    private Logger() {
        LOGGER.setLevel(DEFAULT_LEVEL);
        LOGGER.setUseParentHandlers(false);
        try {
            Handler fileHandler = new FileHandler("./app.log", true);
            fileHandler.setFormatter(MessageFormatter.instance);
            LOGGER.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
