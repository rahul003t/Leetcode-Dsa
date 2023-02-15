class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String num2 = k+"";

        ArrayList<Integer> list = new ArrayList<>();
        int i = num.length-1;
        int j = num2.length()-1;
        int remainder = 0;

        while(i >= 0 || j >= 0 || remainder > 0){

            int a = i >= 0 ?num[i] :0;
            int b = j >= 0 ?num2.charAt(j)-'0' :0;
            i--; j--;

            int sum = a + b + remainder;
            remainder = sum / 10;
            sum %= 10;
            list.add(sum);

        }

        Collections.reverse(list);
        return list;

    }
}