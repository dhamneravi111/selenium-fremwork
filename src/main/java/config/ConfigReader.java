package config;

import java.io.InputStream;import java.util.Properties;

/** Singleton configuration reader with system property and environment variable overrides. */
public final class ConfigReader {
  private static volatile ConfigReader instance; private final Properties props = new Properties();
  private ConfigReader(){ load("config.properties"); String env = get("env", "staging"); load(env + ".properties"); }
  public static ConfigReader getInstance(){ if(instance==null){ synchronized(ConfigReader.class){ if(instance==null) instance=new ConfigReader(); }} return instance; }
  private void load(String file){ try(InputStream in=getClass().getClassLoader().getResourceAsStream(file)){ if(in!=null) props.load(in); } catch(Exception e){ throw new RuntimeException("Unable to load "+file,e);} }
  public String get(String key){ return get(key, null); }
  public String get(String key,String def){ String sys=System.getProperty(key); if(sys!=null&&!sys.isBlank()) return sys; String env=System.getenv(key.toUpperCase().replace('.', '_')); if(env!=null&&!env.isBlank()) return env; return props.getProperty(key,def); }
  public boolean getBoolean(String key){ return Boolean.parseBoolean(get(key,"false")); }
  public int getInt(String key,int def){ return Integer.parseInt(get(key,String.valueOf(def))); }
}
