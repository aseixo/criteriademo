/**
 * 
 */
package com.iuglans.loggerutils;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author arturo
 *
 */
public class LoggerMarker {

	public static Marker persitanceMarker = MarkerFactory.getMarker("PER");
	public static Marker appMarker = MarkerFactory.getMarker("MAIN");
	public static LoggerMarker loggerMarker;

	private LoggerMarker() {
	}

	public LoggerMarker getInstance() {

		if (loggerMarker != null) {
			return new LoggerMarker();
		}
		return null;
	}

	public static Marker getAppMarker() {
		return appMarker;
	}

	public static LoggerMarker getLoggerMarker() {
		return loggerMarker;
	}
	

}
