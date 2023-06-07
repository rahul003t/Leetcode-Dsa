class Solution 
{
    public int minFlips(int a, int b, int c) 
    {
        int flips = 0;
        while(a > 0 || b > 0 || c > 0)
        {
            int a1 = a % 2;
            int b1 = b % 2;
            int c1 = c % 2;
            if(a1 == 1 && b1 == 1 && c1 == 0)
                flips += 2;
            else if(a1 + b1 == 1 && c1 == 0)
                flips++;
            else if(a1 + b1 == 0 && c1 == 1)
                flips++;
            a /= 2;
            b /= 2;
            c /= 2;
        }
        return flips;
    }
}