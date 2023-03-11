package cn.chenzw.denpendence.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.StringLayout;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.WriterAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzw
 */
@Slf4j
public class Log4j2Samples {

    public static void main(String[] args) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        final StringLayout layout = PatternLayout.newBuilder().withPattern("[%-5p]-[%d{yyyy-MM-dd HH:mm:ss}]-[%c:%L]: %m%n").build();
        // ConsoleAppender appender = ConsoleAppender.createDefaultAppenderForLayout(layout);
        final Appender appender = WriterAppender.createAppender(layout, null, new TailStringWriter(), "InMemoryTail", true, true);
        appender.start();
        config.addAppender(appender);
        config.getRootLogger().addAppender(appender, Level.TRACE, null);
        ctx.updateLoggers();

        // 不生效，待解决
        log.info("--------------------------");

        // 不生效，待解决
        Logger logger = LoggerFactory.getLogger(Log4j2Samples.class);
        logger.info("-----------222-----------");
    }

    public static class TailStringWriter extends StringWriter {

        private final AtomicInteger count = new AtomicInteger();

        @Override
        public void flush() {
            super.flush();
            if (2048 <= count.incrementAndGet()) {
                super.getBuffer().setLength(0);
                count.set(0);
            }
        }
    }

}
