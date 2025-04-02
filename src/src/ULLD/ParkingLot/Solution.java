package ULLD.ParkingLot;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    private final Map<Integer, ArrayList<ArrayList<Parking>>> mapFor2;
    private final Map<Integer, ArrayList<ArrayList<Parking>>> mapFor4;
    public Solution(Integer floors, Integer rows, Integer cols) {
        mapFor2 = new ConcurrentHashMap<>();
        mapFor4 = new ConcurrentHashMap<>();
        for (int i = 0; i < floors; i++) {
            ArrayList<ArrayList<Parking>> parkings = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                ArrayList<Parking> parking = new ArrayList<>();
                for(int k = 0; k < cols; k++) {
                    parking.add( new Parking(i,j,k, 2, 100, 0L, false));
                }
                parkings.add(parking);
            }
            mapFor2.put(i, parkings);
        }
        for (int i = 0; i < floors; i++) {
            ArrayList<ArrayList<Parking>> parkings = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                ArrayList<Parking> parking = new ArrayList<>();
                for(int k = 0; k < cols; k++) {
                    parking.add( new Parking(i,j,k, 4, 200, 0L, false));
                }
                parkings.add(parking);
            }
            mapFor4.put(i, parkings);
        }
    }

//    public boolean park(){
//
//    }
//
//    public boolean unpark(){
//
//    }
//
//    public boolean isParkingAvailable(){
//
//    }
//
//    public searchVehicle(){
//
//    }
}
