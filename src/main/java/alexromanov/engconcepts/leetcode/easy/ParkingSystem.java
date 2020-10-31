package alexromanov.engconcepts.leetcode.easy;

/**
 * 1603 - https://leetcode.com/problems/design-parking-system/
 */
public class ParkingSystem {
    private int bA = 0;
    private int mA = 0;
    private int sA = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.bA = big;
        this.mA = medium;
        this.sA = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (bA == 0){
                return false;
            } else {
                bA--;
                return true;
            }

        } else if (carType == 2){
            if (mA == 0){
                return false;
            } else {
                mA--;
                return true;
            }
        } else {
            if (sA == 0){
                return false;
            } else {
                sA--;
                return true;
            }
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
