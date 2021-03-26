package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    //String input = args[0];
    input = input.trim();
    input = input.toLowerCase();
    ClientNameResolver clientNameResolver = new ClientNameResolver(input);
    clientNameResolver.sendURL();
    System.out.println("Final Address: " + clientNameResolver.getNumber());
  }
}

class ClientNameResolver {

  private final String url;
  private RootNameResolver rootNameResolver = new RootNameResolver();

  public ClientNameResolver(String url) {
    this.url = url;
  }

  public void sendURL() {
    rootNameResolver.load(url);
  }

  public String getNumber() {
    return rootNameResolver.getNumber();
  }

}

class RootNameResolver {

  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final NameServer nameServer1 = new NameServer();

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

class NameServer {


  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final DepartmentServer nameServer2 = new DepartmentServer();

  public NameServer() {
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

class DepartmentServer {


  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  private final ProtocolServer nameServer3 = new ProtocolServer();

  public DepartmentServer() {
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

class ProtocolServer {

  private String address = "";
  private Integer number = 0;
  private final Map<String, Integer> domains = new HashMap<>();

  public ProtocolServer() {
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
