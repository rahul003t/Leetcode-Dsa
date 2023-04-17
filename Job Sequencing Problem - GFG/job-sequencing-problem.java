//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
        public int compare(Job n1, Job n2) {
           if(n1.profit != n2.profit){
               return n2.profit-n1.profit; 
           }else if(n1.deadline != n2.deadline){
                return n2.deadline-n1.deadline;    
           }
           return n2.id-n1.id;
        }
    });
        int dlu = 0; 
        Set<Integer> set = new HashSet<>(); 
        int cnt=0, ans=0; 
        for(Job x : arr){
            pq.offer(x); 
        }
        while(!pq.isEmpty()){
            Job cur = pq.poll();
            while(set.contains(cur.deadline)){
                cur.deadline--; 
            }
            if(set.contains(cnt+1)){
                cnt++; 
                set.remove(cnt); 
            } 
            if(cur.deadline > cnt){
                if(cur.deadline == 1+cnt){
                    cnt++; 
                    ans+=cur.profit; 
                    dlu++;
                }else{
                    set.add(cur.deadline);
                    ans+=cur.profit; 
                    dlu++;
                } 
            }
           
        }
        return new int[]{dlu, ans}; 
    }
}