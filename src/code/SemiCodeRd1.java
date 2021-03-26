package code;
import java.util.Scanner;

public class SemiCodeRd1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i = 0;i<T;i++){
      int X = sc.nextInt();
      int Y = sc.nextInt();
      int dist = X-Y;
      int money = sc.nextInt();
      int N = sc.nextInt();
      Can cans[] = new Can[N];
      for(int j = 0;j<N;j++){
        int p = sc.nextInt();
        int c = sc.nextInt();

        cans[j] = new Can(c,p);
      }

      int min = Integer.MAX_VALUE;
      int ctr = 0;
      int x = 1;
      int minCost = Integer.MAX_VALUE;

      for(Can c: cans){
        if(c.cost <= money && c.dist >= dist){
          ctr++;
          // min = c.cost < min?x:min;
          if (minCost > c.cost) {
            minCost = c.cost;
            min = x;
          }
        }
        x++;
      }
      System.out.println(min);
      System.out.println(ctr);
    }
  }
}
class Can {
  int cost = 0, dist = 0;
  public Can(int cost, int dist) {
    this.cost = cost;
    this.dist = dist;
  }
}