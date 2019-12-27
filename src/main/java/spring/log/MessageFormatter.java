package spring.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MessageFormatter extends Formatter {

    public static final MessageFormatter instance = new MessageFormatter();

    private MessageFormatter() {}

    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getSourceClassName() + "::" + logRecord.getSourceMethodName() + "::"
                + new Date(logRecord.getMillis()) + "::" + logRecord.getMessage() + "\n";
    }
}
