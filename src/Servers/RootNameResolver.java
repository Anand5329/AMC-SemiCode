package Servers;

import java.util.HashMap;
import java.util.Map;

public class RootNameResolver {

  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final NameServer1 nameServer1 = new NameServer1();

  public RootNameResolver() {
    domains.put("edu", 121);
    domains.put("com", 123);
    domains.put("in", 120);
  }

  public void load(String url) {
    int lastPeriod = url.lastIndexOf(".") + 1;
    address = url.substring(lastPeriod);
    url = url.substring(0, lastPeriod - 1);

    if (domains.containsKey(address)) {
      number = domains.get(address);
      System.out.println("Root Address: " + number);
      nameServer1.load(url);
    }
  }

  public String getNumber() {
    return nameServer1.getNumber() + "." + number;
  }

}
