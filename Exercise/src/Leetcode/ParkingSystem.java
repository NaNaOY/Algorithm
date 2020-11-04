package Leetcode;

class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    int[] Parking=new int []{0,big,medium,small};

    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;

    }

    public boolean addCar(int carType) {
        if (0 < Parking[carType ]) {
            this.Parking[carType ] -= 1;
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }

    }
    public static void main(String[] args){
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        parkingSystem.addCar(1);
        parkingSystem.addCar(2);
        parkingSystem.addCar(3);
        parkingSystem.addCar(1);


    }
}