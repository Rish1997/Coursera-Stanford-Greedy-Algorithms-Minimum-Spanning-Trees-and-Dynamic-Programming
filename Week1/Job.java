import java.util.*;
import java.io.*;

class Job {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner((new FileInputStream("./jobs.txt")));
        int numOfJobs = sc.nextInt();
        //int[][] arr = new int[10000][2];
        Integer[] weight = new Integer[10000];
        Integer[] length = new Integer[10000];
        Integer[][] diff = new Integer[10000][2];
        for (int i = 0; i < numOfJobs; i++) {
            weight[i] = sc.nextInt();
            length[i] = sc.nextInt();
            diff[i][0] = weight[i] - length[i];
            diff[i][1] = i+1; 
        }

        // Arrays.sort(diff);
        Arrays.sort(diff, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] int1, Integer[] int2) {
                Integer numOfKeys1 = int1[0];
                Integer numOfKeys2 = int2[0];
                if(numOfKeys1.compareTo(numOfKeys2) == 0){
                    return weight[int1[1]-1].compareTo(weight[int2[1]-1]);
                }
                else return numOfKeys1.compareTo(numOfKeys2);
            }
        });
        // for (int i = 0; i < 10000; i++) {
        //     System.out.println(diff[i][1]);
        // }
        long sum =0 , lengthCal = 0;

        for(int i = 9999 ; i > -1 ; i--){
            sum += weight[diff[i][1]-1]*(length[diff[i][1]-1] + lengthCal);
            lengthCal += length[diff[i][1]-1];
        }
        System.out.println(sum);

        BufferedWriter output = null;
        try {
            File file = new File("output1.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(sum+"");
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
    }
}