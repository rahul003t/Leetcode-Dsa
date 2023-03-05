//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {

   class DisjointSet{

        int []parent,rank;

        int n;

        DisjointSet(int n){

            parent=new int[n];

            rank=new int[n];

            this.n=n;

            for(int i=0;i<n;i++)

            parent[i]=i;

        }

        int find(int x){

            if(parent[x]!=x)

            parent[x]=find(parent[x]);

            return parent[x];

        }

        void union(int x,int y){

            int xroot=find(x),yroot=find(y);

            if(xroot==yroot)

            return;

            if(rank[xroot]<rank[yroot]){

                parent[xroot]=yroot;

            }

            else if(rank[yroot]<rank[xroot]){

                parent[yroot]=xroot;

            }

            else{

                parent[yroot]=xroot;

                rank[xroot]+=1;

            }

        }

    }

    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {

    ArrayList<String> arr=new ArrayList<>();

    DisjointSet dsu=new DisjointSet(n);

    

    for(int i=0;i<n;i++){

        int m1=dsu.find(mix[i][0]-1),m2=dsu.find(mix[i][1]-1);

        boolean dang=false;

        for(int j=0;j<m;j++){

            int d1=dsu.find(danger[j][0]-1),d2=dsu.find(danger[j][1]-1);

            if((m1==d1&&m2==d2)||(m1==d2&&m2==d1)){

            dang=true;

            break;

        }

    }

    if(!dang){

    dsu.union(m1,m2);

    arr.add("Yes");

    }

    else arr.add("No");

}

return arr;}

}

     

     
