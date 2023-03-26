package seedu.duke.commons;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogMaster {
    private static final String LOG_FILE = "fitness_duke.log";
    private static ConsoleHandler consoleHandler;
    private static FileHandler fileHandler;
    private static final Logger logger = LogMaster.getLogger(LogMaster.class);

    public static Logger getLogger (String name) {
        Logger logger = Logger.getLogger(name);
        if (consoleHandler == null) {
            consoleHandler = createConsoleHandler();
            logger.addHandler(consoleHandler);
        }
        try {
            if (fileHandler == null) {
                fileHandler = createFileHandler();
            }
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.warning("Unable to create file handler for logger");
        }
        return Logger.getLogger(name);
    }

    public static <T> Logger getLogger (Class<T> myClass) {
        if (myClass == null) {
            return Logger.getLogger("");
        }
        return getLogger(myClass.getSimpleName());
    }

    private static FileHandler createFileHandler () throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE, true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.FINE);
        return fileHandler;
    }

    private static ConsoleHandler createConsoleHandler () {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        return consoleHandler;
    }

}