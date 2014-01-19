/* Forge Mod Loader Copyright (c) 2012-2013 cpw. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the GNU Lesser Public License v2.1 which accompanies this distribution, and
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Contributors: cpw - implementation */
package com.warlordjones.warcore;

/**
 * Copied from ConsoleLogFormatter for shared use on the client
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class FMLLogFormatter extends Formatter {
    static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(
	    "yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(final LogRecord record) {
	final StringBuilder msg = new StringBuilder();
	msg.append(dateFormat.format(Long.valueOf(record.getMillis())));
	final Level lvl = record.getLevel();
	String name = lvl.getLocalizedName();
	if (name == null)
	    name = lvl.getName();
	if (name != null && name.length() > 0)
	    msg.append(" [" + name + "] ");
	else
	    msg.append(" ");
	if (record.getLoggerName() != null)
	    msg.append("[" + record.getLoggerName() + "] ");
	else
	    msg.append("[] ");
	msg.append(formatMessage(record));
	msg.append(FMLLogFormatter.LINE_SEPARATOR);
	final Throwable thr = record.getThrown();
	if (thr != null) {
	    final StringWriter thrDump = new StringWriter();
	    thr.printStackTrace(new PrintWriter(thrDump));
	    msg.append(thrDump.toString());
	}
	return msg.toString();
    }
}
