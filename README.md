# Log4j2 + Disruptor

Log4j2 utiliza la biblioteca LMAX Disruptor para ofrecer un registro asíncrono libre de bloqueos (lock-free), con una
latencia ultra baja y un rendimiento masivo. Al reemplazar las colas de bloqueo tradicionales por el Ring Buffer de
Disruptor, desacopla el hilo de la aplicación de las operaciones de entrada/salida (I/O), evitando cuellos de botella en
aplicaciones Java concurrentes.

## Configuración y dependencias

Para activar este mecanismo, debes añadir la biblioteca Disruptor a las dependencias de tu proyecto junto con Log4j2.

Dependencia en Maven (pom.xml)

```
<dependency>
<groupId>com.lmax</groupId>
<artifactId>disruptor</artifactId>
<version>3.4.4</version> <!-- Usa 4.x para versiones recientes de Log4j2 -->
</dependency>
```

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.24.1</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.24.1</version>
</dependency>
<!-- Bridge SLF4J → Log4j2 (HikariCP, MongoDB driver usan SLF4J) -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j2-impl</artifactId>
    <version>2.24.1</version>
</dependency>
```

## Configuración del sistema

Para que todos tus loggers pasen a ser asíncronos por defecto, debes establecer una propiedad del sistema al arrancar tu Máquina Virtual de Java (JVM).

Propiedad del sistema:

```
-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
-Dlog4j2.debug=true
```
## Log de consola solo en entorno DEV

```
-Denv=DEV
```