import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;

class KCluster {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileInputStream("./kclustering.txt"));
    int ver = sc.nextInt();
    Integer[][] values = new Integer[124750][3];
    int count = 0;
    while (sc.hasNext()) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      values[count][0] = a;
      values[count][1] = b;
      values[count][2] = c;
      count++;
    }
    Arrays.sort(values, new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] int1, Integer[] int2) {
        Integer numOfKeys1 = int1[2];
        Integer numOfKeys2 = int2[2];
        return numOfKeys1.compareTo(numOfKeys2);
      }
    });

    // Set<Integer> b[] = new Set<Integer>();

    ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();

    for(int i = 124746 ; i < 124750 ; i++){
      System.out.println(values[i][0] + " " + values[i][1] + " " + values[i][2]);
    }
    sc.close();
  }
}