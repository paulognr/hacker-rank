import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Paulo on 2017-09-09.
 */
public class Solution {

    static List<Integer> greatestFlightRangeDrones(
            Integer numberOfRequiredDrones,
            List<Drone> drones,
            List<Integer> inMaintenanceDrones) {

        List<Integer> response = drones.stream()
                .filter(drone -> {
                    return !inMaintenanceDrones.contains(drone.getId());
                })
                .sorted(Comparator.comparing(Drone::getFlightRange).reversed())
                .limit(numberOfRequiredDrones)
                .map(drone -> drone.getId())
                .collect(java.util.stream.Collectors.toList());

        return response;
    }

    private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {

            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }

    public static void main(String[] args) {
        int numberOfDrones = 7;
        int numberOfRequiredDrones = 3;
        int numberOfDronesInMaintenance = 3;

        List<Drone> drones = new ArrayList<>();
        List<Integer> inMaintenanceDrones = new ArrayList<>();

        drones.add(new Drone(4, 11));
        drones.add(new Drone(2, 15));
        drones.add(new Drone(5, 16));
        drones.add(new Drone(3, 40));
        drones.add(new Drone(1, 20));
        drones.add(new Drone(9, 60));
        drones.add(new Drone(6, 22));

        inMaintenanceDrones.add(1);
        inMaintenanceDrones.add(5);
        inMaintenanceDrones.add(9);

        List<Integer> greatestFlightRangeDrones = greatestFlightRangeDrones(numberOfRequiredDrones, drones, inMaintenanceDrones);

        for (int i = 0; i < greatestFlightRangeDrones.size(); i++) {
            System.out.println(greatestFlightRangeDrones.get(i));
        }
    }
}