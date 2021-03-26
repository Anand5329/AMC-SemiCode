package code;

import java.util.HashMap;
import java.util.Map;

public class NameServer2 {


  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final NameServer3 nameServer3 = new NameServer3();

  public NameServer2() {
    domains.put("cs", 100);
    domains.put("extc", 102);
    domains.put("it", 101);
  }

  public void load(String url) {
    int lastPeriod = url.lastIndexOf(".") + 1;
    address = url.substring(lastPeriod);
    url = url.substring(0, lastPeriod - 1);

    if (domains.containsKey(address)) {
      number = domains.get(address);
      System.out.println("Department Address: " + number);
      nameServer3.load(url);
    }
  }

  public String getNumber() {
    return nameServer3.getNumber() + "." + number;
  }
}
