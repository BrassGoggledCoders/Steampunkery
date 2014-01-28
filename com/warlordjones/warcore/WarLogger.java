/* Forge Mod Loader Copyright (c) 2012-2013 cpw. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the GNU Lesser Public License v2.1 which accompanies this distribution, and
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Contributors: cpw - implementation */
package com.warlordjones.warcore;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.*;

import com.google.common.base.Throwables;

import net.minecraft.launchwrapper.LogWrapper;

public class WarLogger {
    private static class ConsoleLogThread implements Runnable {
	static LinkedBlockingQueue<LogRecord> recordQueue = new LinkedBlockingQueue<LogRecord>();
	static ConsoleHandler wrappedHandler = new ConsoleHandler();

	@Override
	public void run() {
	    do {
		LogRecord lr;
		try {
		    lr = ConsoleLogThread.recordQueue.take();
		    ConsoleLogThread.wrappedHandler.publish(lr);
		} catch (final InterruptedException e) {
		    e.printStackTrace(WarLogger.errCache);
		    Thread.interrupted();
		    // Stupid
		}
	    } while (true);
	}
    }

    private static class ConsoleLogWrapper extends Handler {
	@Override
	public void close() throws SecurityException {
	}

	@Override
	public void flush() {
	}

	@Override
	public void publish(final LogRecord record) {
	    final boolean currInt = Thread.interrupted();
	    try {
		ConsoleLogThread.recordQueue.put(record);
	    } catch (final InterruptedException e) {
		e.printStackTrace(WarLogger.errCache);
	    }
	    if (currInt)
		Thread.currentThread().interrupt();
	}
    }

    private static class LoggingOutStream extends ByteArrayOutputStream {
	private final StringBuilder currentMessage;
	private final Logger log;

	public LoggingOutStream(final Logger log) {
	    this.log = log;
	    currentMessage = new StringBuilder();
	}

	@Override
	public void flush() throws IOException {
	    String record;
	    synchronized (WarLogger.class) {
		super.flush();
		record = this.toString();
		super.reset();
		currentMessage.append(record.replace(
			FMLLogFormatter.LINE_SEPARATOR, "\n"));
		// Are we longer than just the line separator?
		int lastIdx = -1;
		int idx = currentMessage.indexOf("\n", lastIdx + 1);
		while (idx >= 0) {
		    log.log(Level.INFO,
			    currentMessage.substring(lastIdx + 1, idx));
		    lastIdx = idx;
		    idx = currentMessage.indexOf("\n", lastIdx + 1);
		}
		if (lastIdx >= 0) {
		    final String rem = currentMessage.substring(lastIdx + 1);
		    currentMessage.setLength(0);
		    currentMessage.append(rem);
		}
	    }
	}
    }

    /**
     * Our special logger for logging issues to. We copy various assets from the
     * Minecraft logger to achieve a similar appearance.
     */
    public static WarLogger log = new WarLogger();
    private static boolean configured;
    private static Thread consoleLogThread;
    private static PrintStream errCache;
    private static FileHandler fileHandler;
    private static FMLLogFormatter formatter;
    static String logFileNamePattern;
    static File minecraftHome;

    public static void fine(final String format, final Object... data) {
	WarLogger.log(Level.FINE, format, data);
    }

    public static void finer(final String format, final Object... data) {
	WarLogger.log(Level.FINER, format, data);
    }

    public static void finest(final String format, final Object... data) {
	WarLogger.log(Level.FINEST, format, data);
    }

    public static void info(final String format, final Object... data) {
	WarLogger.log(Level.INFO, format, data);
    }

    public static void loadLogConfiguration(final File logConfigFile) {
	if (logConfigFile != null && logConfigFile.exists()
		&& logConfigFile.canRead())
	    try {
		LogManager.getLogManager().readConfiguration(
			new FileInputStream(logConfigFile));
		WarLogger.resetLoggingHandlers();
	    } catch (final Exception e) {
		WarLogger.log(Level.SEVERE, e,
			"Error reading logging configuration file %s",
			logConfigFile.getName());
	    }
    }

    public static void log(final Level level, final String format,
	    final Object... data) {
	if (!WarLogger.configured)
	    WarLogger.configureLogging();
	WarLogger.log.myLog.log(level, String.format(format, data));
    }

    public static void log(final Level level, final Throwable ex,
	    final String format, final Object... data) {
	if (!WarLogger.configured)
	    WarLogger.configureLogging();
	WarLogger.log.myLog.log(level, String.format(format, data), ex);
    }

    public static void log(final String logChannel, final Level level,
	    final String format, final Object... data) {
	WarLogger.makeLog(logChannel);
	Logger.getLogger(logChannel).log(level, String.format(format, data));
    }

    public static void log(final String logChannel, final Level level,
	    final Throwable ex, final String format, final Object... data) {
	WarLogger.makeLog(logChannel);
	Logger.getLogger(logChannel)
		.log(level, String.format(format, data), ex);
    }

    public static void makeLog(final String logChannel) {
	final Logger l = Logger.getLogger(logChannel);
	l.setParent(WarLogger.log.myLog);
    }

    public static void severe(final String format, final Object... data) {
	WarLogger.log(Level.SEVERE, format, data);
    }

    public static void warning(final String format, final Object... data) {
	WarLogger.log(Level.WARNING, format, data);
    }

    /**
     * Configure the FML logger
     */
    private static void configureLogging() {
	LogManager.getLogManager().reset();
	final Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	globalLogger.setLevel(Level.OFF);
	WarLogger.log.myLog = Logger.getLogger("ForgeModLoader");
	LogWrapper.retarget(WarLogger.log.myLog);
	final Logger stdOut = Logger.getLogger("STDOUT");
	stdOut.setParent(WarLogger.log.myLog);
	final Logger stdErr = Logger.getLogger("STDERR");
	stdErr.setParent(WarLogger.log.myLog);
	WarLogger.log.myLog.setLevel(Level.ALL);
	WarLogger.log.myLog.setUseParentHandlers(false);
	WarLogger.consoleLogThread = new Thread(new ConsoleLogThread());
	WarLogger.consoleLogThread.setDaemon(true);
	WarLogger.consoleLogThread.start();
	WarLogger.formatter = new FMLLogFormatter();
	try {
	    final File logPath = new File(WarLogger.minecraftHome,
		    WarLogger.logFileNamePattern);
	    WarLogger.fileHandler = new FileHandler(logPath.getPath(), 0, 3) {
		@Override
		public synchronized void close() throws SecurityException {
		    // We don't want this handler to reset
		}
	    };
	} catch (final Throwable t) {
	    throw Throwables.propagate(t);
	}
	WarLogger.resetLoggingHandlers();
	// Set system out to a log stream
	WarLogger.errCache = System.err;
	System.setOut(new PrintStream(new LoggingOutStream(stdOut), true));
	System.setErr(new PrintStream(new LoggingOutStream(stdErr), true));
	WarLogger.configured = true;
    }

    private static void resetLoggingHandlers() {
	ConsoleLogThread.wrappedHandler.setLevel(Level.parse(System
		.getProperty("fml.log.level", "INFO")));
	// Console handler captures the normal stderr before it gets replaced
	WarLogger.log.myLog.addHandler(new ConsoleLogWrapper());
	ConsoleLogThread.wrappedHandler.setFormatter(WarLogger.formatter);
	WarLogger.fileHandler.setLevel(Level.ALL);
	WarLogger.fileHandler.setFormatter(WarLogger.formatter);
	WarLogger.log.myLog.addHandler(WarLogger.fileHandler);
    }

    private Logger myLog;

    private WarLogger() {
    }

    public Logger getLogger() {
	return myLog;
    }
}
