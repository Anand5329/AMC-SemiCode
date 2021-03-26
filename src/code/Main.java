package code;

public class Main {

  public static void main(String[] args) {
    ClientNameResolver clientNameResolver = new ClientNameResolver(args[0]);
    clientNameResolver.sendURL();
    System.out.println("Final Address: " + clientNameResolver.getNumber());
  }
}
