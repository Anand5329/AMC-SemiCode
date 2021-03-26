package code;

import java.util.HashMap;
import java.util.Map;

public class NameServer1 {


  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final NameServer2 nameServer2 = new NameServer2();

  public NameServer1() {
    domains.put("nm", 111);
    domains.put("dj", 112);
    domains.put("sp", 113);
  }

  public void load(String url) {
    int lastPeriod = url.lastIndexOf(".") + 1;
    address = url.substring(lastPeriod);
    url = url.substring(0, lastPeriod - 1);

    if (domains.containsKey(address)) {
      number = domains.get(address);
      System.out.println("Name Address: " + number);
      nameServer2.load(url);
    }
  }

  public String getNumber() {
    return nameServer2.getNumber() + "." + number;
  }

}
