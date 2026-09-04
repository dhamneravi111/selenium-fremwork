package reporting;
import com.aventstack.extentreports.ExtentTest;
public final class ExtentTestManager { private static final ThreadLocal<ExtentTest> TEST=new ThreadLocal<>(); private ExtentTestManager(){} public static void set(ExtentTest t){ TEST.set(t);} public static ExtentTest get(){ return TEST.get();} public static void remove(){ TEST.remove(); } }
