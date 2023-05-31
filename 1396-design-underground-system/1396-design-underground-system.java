class CheckedIn{
    String stationName;
    int time;

    public CheckedIn(String stationName, int time){
        this.stationName = stationName;
        this.time = time;
    }
    public String getStationName(){
        return stationName;
    }
    public int getTime(){
        return time;
    }
}

class UndergroundSystem {

    Map<Integer,CheckedIn> checkedIn;
    Map<String, List<Integer>> averageTimeFinderBySrcDest; 

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        averageTimeFinderBySrcDest = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new CheckedIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckedIn output = checkedIn.get(id);
        String srcDestKey  = output.getStationName() + "->" +  stationName;

       List<Integer> dist =  averageTimeFinderBySrcDest.computeIfAbsent(srcDestKey, k-> new ArrayList<>());
       dist.add(t - output.getTime());

    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        List<Integer> res = averageTimeFinderBySrcDest.get(key);

        int sum = 0;
        for(int i: res){
            sum += i;
        }
        return (double) sum/res.size();
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */