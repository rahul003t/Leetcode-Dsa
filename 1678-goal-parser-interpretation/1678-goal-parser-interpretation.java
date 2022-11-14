class Solution {
    public String interpret(String command) {
        
        //return command.replace("()","o").replace("(al)","al");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<command.length();i++)
        {
            if(command.charAt(i) =='(' && command.charAt(i+1) == ')')
            {
                sb.append("o");
                i+=1;
            }
            else if(command.charAt(i) =='(' && command.charAt(i+1) != ')')
            {
                sb.append("al");
                i+=3;
            }
            else
            {
                sb.append(command.charAt(i));
            }
        }
        
        return sb.toString();
    }
}