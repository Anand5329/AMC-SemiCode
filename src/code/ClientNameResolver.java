package code;

public class ClientNameResolver {

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
