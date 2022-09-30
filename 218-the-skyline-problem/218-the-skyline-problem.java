class Solution {
    public List<List<Integer>> getSkyline(int[][] arr) {
        List<List<Integer>> skyline = new ArrayList<>();
        List<Building> buildings = build(arr);
        Collections.sort(buildings, (a,b) -> a.x == b.x ? a.height - b.height : a.x - b.x); // if two building are on same x co-ordinate sort by heigh otherwise by x
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); // max PQ by height
        pq.add(0); // add intial ground height
        int prevMaxHeight = Integer.MIN_VALUE;
        for(Building building : buildings){
            if(building.height < 0){// -ve height means starting point
                pq.add(building.height*-1);
            }else{
                 pq.remove(building.height); // +ve height means ending point so remove
            }
            
            int currMaxHeight = pq.peek(); 
            if(currMaxHeight != prevMaxHeight){
                skyline.add(Arrays.asList(building.x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }   
        return skyline;
    }
    
    private List<Building> build(int[][] arr){
        List<Building> list = new ArrayList<>();
        for(int[] curr : arr){
            list.add(new Building(curr[0], -curr[2])); // make the height negative to indicate starting point
            list.add(new Building(curr[1], curr[2])); // positive indicates ending point of the building
        }
        return list;
    }
    
}


class Building{
    int x;
    int height;
    
    public Building(int x, int height){
        this.x = x;
        this.height = height;
    }
} 