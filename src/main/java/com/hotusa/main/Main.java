package com.hotusa.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // Esto fuerza a Log4j2 a usar el modo asíncrono antes de que se inicie el sistema de logs
        //JAVA_OPTS="$JAVA_OPTS -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"
        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");

        int numLogs = 100_000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numLogs; i++) {
            log.info("Log de prueba numero {} - Datos simulados: {}", i, "contenido extenso...");
        }
        long endTime = System.currentTimeMillis();
        log.info("Tiempo total para " + numLogs + " logs: " + (endTime - startTime) + " ms");
        LogManager.shutdown();
    }
}
