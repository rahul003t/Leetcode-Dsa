//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
	public static void main (String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
                
        int t=Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            String s=in.readLine().trim();
            int q=Integer.parseInt(in.readLine().trim());
            query a[]=new query[q];
            for(int i=0;i<q;i++){
                String str=in.readLine().trim();
                String st[]=str.split(" ");
                if(st[0].trim().equals("1")){
                    a[i]=new query("1",st[1],st[2],"");
                }else{
                    a[i]=new query("2",st[1],st[2],st[3]);
                }
            }
            Solution ob=new Solution();
            ArrayList<Character> ans=ob.easyTask(n,s,q,a);
            for(char ch:ans){
                out.print(ch+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        ArrayList<Character> aa = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<q;i++){
            
            query queryx =queries[i];
            
            
            if(queryx.type=="1"){
                int idx= Integer.parseInt(queryx.a);
                sb.setCharAt(idx,(queryx.b).charAt(0));
                
            }else{
                int st=Integer.parseInt(queryx.a);
                int e=Integer.parseInt(queryx.b);
                int k=Integer.parseInt(queryx.c);
                
                String wrk = (sb.substring(st,e+1)).toString();
                lexoSort(aa,wrk,k);
            }
        }
        return aa;
    }
    
    public static void lexoSort(ArrayList<Character> aa ,String s,int k){
        int[] str = new int[26];
        for(char c : s.toCharArray() ){
            str[c-'a']++;
        }
        int count =k;
        int i=25;
        for(;i>=0;i--){
            count = count-str[i];
            
            if(count<=0) break;
        }
        
        aa.add((char)('a'+i));
    }
}


/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}