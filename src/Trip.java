import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Paulo on 2017-09-09.
 */
public class Solution2 {

    static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
        Arrays.sort(packagesWeight);

        int trips = 0;
        while(packagesWeight.length > 0){
            int tripWeight = 0;
            int tripSeat[] = new int[2];
            for (int i = packagesWeight.length - 1; i >= 0; i--) {
                if (tripWeight == 0) {
                    tripSeat[0] = tripWeight = packagesWeight[i];
                    continue;
                }

                if(tripWeight + packagesWeight[i] > 100){
                    continue;
                }

                tripSeat[1] = packagesWeight[i];
                break;
            }

            packagesWeight = removeElement(packagesWeight, tripSeat[0]);
            packagesWeight = removeElement(packagesWeight, tripSeat[1]);
            trips++;

            System.out.println("Trip nº" + trips + " values: " + tripSeat[0] + "-" + tripSeat[1]);
        }

        return trips;
    }

    private static int[] removeElement(int[] packagesWeight, int element){
        if(element == 0){
            return packagesWeight;
        }

        int index = -1;

        for(int i = 0; i < packagesWeight.length; i++){
            if(element == packagesWeight[i]){
                index = i;
                break;
            }
        }

        int[] result = new int[packagesWeight.length - 1];
        System.arraycopy(packagesWeight, 0, result, 0, index);
        System.arraycopy(packagesWeight, index+1, result, index, result.length-index);
        return result;
    }

    public static void main(String[] args) {
        int tripMaxWeight = 100;
        int numberOfPackages = 10;

        int[] packagesWeight = new int[numberOfPackages];

        packagesWeight[0] = 70;
        packagesWeight[1] = 31;
        packagesWeight[2] = 40;
        packagesWeight[3] = 70;
        packagesWeight[4] = 90;
        packagesWeight[5] = 10;
        packagesWeight[6] = 1;
        packagesWeight[7] = 23;
        packagesWeight[8] = 99;
        packagesWeight[9] = 45;

        int minimumNumberOfTrips = minimumNumberOfTrips(tripMaxWeight, packagesWeight);

        System.out.println(minimumNumberOfTrips);
    }
}
