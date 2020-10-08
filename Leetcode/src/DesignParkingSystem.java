public class DesignParkingSystem {
    int[] capacity;

    public DesignParkingSystem(int big, int medium, int small) {
        capacity = new int[3];
        capacity[0] = big;
        capacity[1] = medium;
        capacity[2] = small;
    }

    //big - 1, medium - 2, small - 3
    public boolean addCar(int carType) {
        if (capacity[carType - 1] > 0) {
            capacity[carType - 1]--;
            return true;
        }
        return false;
    }
}
