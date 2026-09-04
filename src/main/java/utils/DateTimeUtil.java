package utils;
import java.time.*;import java.time.format.DateTimeFormatter;
public final class DateTimeUtil { private DateTimeUtil(){} public static String timestamp(){ return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS")); } public static String isoNow(){ return Instant.now().toString(); } }
