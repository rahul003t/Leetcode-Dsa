class ParkingSystem {
    int[] capacities;
    int[] counts;

    public ParkingSystem(int big, int medium, int small) {
        this.capacities = new int[]{-1, big, medium, small};
        this.counts = new int[]{-1,0,0,0};
    }
    
    public boolean addCar(int carType) {
       if(this.counts[carType] < this.capacities[carType]){
           this.counts[carType]++;
           return true;
       }
       return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */