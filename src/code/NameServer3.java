package code;

import java.util.HashMap;
import java.util.Map;

public class NameServer3 {

  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  public NameServer3() {
    domains.put("ftp", 20);
    domains.put("smtp", 25);
    domains.put("http", 80);
  }

  public void load(String url) {
    int lastPeriod = url.lastIndexOf(".") + 1;
    address = url.substring(lastPeriod);

    if (domains.containsKey(address)) {
      number = domains.get(address);
      System.out.println("Protocol Address: " + number);
    }
  }

  public Integer getNumber() {
    return number;
  }
}
