package utils;
import org.testng.asserts.SoftAssert;
public final class SoftAssertManager { private static final ThreadLocal<SoftAssert> SA=ThreadLocal.withInitial(SoftAssert::new); private SoftAssertManager(){} public static SoftAssert get(){ return SA.get(); } public static void assertAll(){ try{ SA.get().assertAll(); } finally { SA.remove(); } } }
