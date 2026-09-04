package utils;
import java.util.UUID;import java.util.concurrent.ThreadLocalRandom;
public final class RandomDataUtil { private RandomDataUtil(){} public static String email(){ return "user_"+UUID.randomUUID().toString().substring(0,8)+"@example.com";} public static String name(){ return "Test User "+ThreadLocalRandom.current().nextInt(10000);} public static String phone(){ return "+9745"+ThreadLocalRandom.current().nextInt(1000000,9999999);} }
