import java.util.*;
import java.io.*;

class JobOpt {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner((new FileInputStream("./jobs.txt")));
        int numOfJobs = sc.nextInt();
        //int[][] arr = new int[10000][2];
        Double[] weight = new Double[10000];
        Double[] length = new Double[10000];
        Double[][] rate = new Double[10000][2];
        for (int i = 0; i < numOfJobs; i++) {
            weight[i] = sc.nextDouble();
            length[i] = sc.nextDouble();
            rate[i][0] = weight[i] / length[i];
            rate[i][1] = (i+1)/1.0; 
        }

        // Arrays.sort(diff);
        Arrays.sort(rate, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] int1, Double[] int2) {
                Double numOfKeys1 = int1[0];
                Double numOfKeys2 = int2[0];
                if(numOfKeys1.compareTo(numOfKeys2) == 0){
                    return weight[(int1[1].intValue()-1)].compareTo(weight[int2[1].intValue()-1]);
                }
                else return numOfKeys1.compareTo(numOfKeys2);
            }
        });
        // for (int i = 0; i < 10000; i++) {
        //     System.out.println(diff[i][1]);
        // }
        long sum =0 , lengthCal = 0;

        for(int i = 9999 ; i > -1 ; i--){
            sum += weight[rate[i][1].intValue()-1]*(length[rate[i][1].intValue()-1] + lengthCal);
            lengthCal += length[rate[i][1].intValue()-1];
        }
        System.out.println(sum);

        BufferedWriter output = null;
        try {
            File file = new File("output2.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(sum + "");
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
    }
}