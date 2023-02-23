class Solution {

    class Project {
        int capital;
        int profit;
        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        final int n = profits.length;

        PriorityQueue<Project> queue1 = new PriorityQueue<Project>((a,b) -> a.capital - b.capital);
        PriorityQueue<Project> queue2 = new PriorityQueue<Project>((a,b) -> b.profit - a.profit);

        for(int i=0; i<n; i++){
            Project p = new Project(capital[i], profits[i]);
            queue1.add(p);
        }

        while(k-- > 0){
            while(!queue1.isEmpty() && queue1.peek().capital <= w){
                queue2.add(queue1.poll());
            }

            if(!queue2.isEmpty()){
                w += queue2.poll().profit;
            }
        }

       
        return w;
    }
}