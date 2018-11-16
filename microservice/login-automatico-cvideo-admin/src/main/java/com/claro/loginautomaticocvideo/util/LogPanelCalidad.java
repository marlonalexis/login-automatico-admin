package com.claro.loginautomaticocvideo.util;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class LogPanelCalidad {
	
	private static final Logger log = LogManager.getLogger(LogPanelCalidad.class);
	
	public void logError(long startTime, long endTime, String operacion, String mensaje, String clase) {
    	long ejecutionTime = NANOSECONDS.toMillis(endTime-startTime);
		log.error("[ "+clase+" ] Operacion Fallida: " + operacion + " - "+ mensaje);
		log.info("Tiempo de ejecucion: " + ejecutionTime + " Miliseg");
	}
	
	public void logInfo(long startTime, long endTime, String operacion, String mensaje, String clase) {
		long ejecutionTime = NANOSECONDS.toMillis(endTime-startTime);
		log.info("[ "+clase+" ] Operacion Exitosa: " + operacion + " - "+ mensaje);
		log.info("Tiempo de ejecucion: " + ejecutionTime + " Miliseg");
	}
	
	public void logDebug(String operacion, String mensaje, String clase) {
		//long ejecutionTime = NANOSECONDS.toMillis(endTime-startTime);
		log.debug("[ "+clase+" ] Operacion Exitosa: " + operacion + " - "+ mensaje);
		//log.info("Tiempo de ejecucion: " + ejecutionTime + " Miliseg");
	}
	
	public void logMensaje(String mensaje, String clase) {
		log.info("[ "+clase+" ] "+ mensaje);
	}
}

