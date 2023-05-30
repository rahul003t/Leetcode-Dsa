class Solution {
    public static void generate(int n,int oc,int cc,String ans,List<String> result){
        if(oc==n && cc==n){
            result.add(ans);
            return;
        }
        if(oc<n){
            generate(n,oc+1,cc,ans+"(",result);
        }
        if(oc>cc){
            generate(n,oc,cc+1,ans+")",result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,0,0,"",result);
        return result;
    }
}