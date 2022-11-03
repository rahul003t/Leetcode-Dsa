class Solution{
public double average(int[] salary) {
	double sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	for(int i: salary) 
    {
		sum += i;
		max = Math.max(max, i);
		min = Math.min(min, i);
	}
	sum -= min + max;
	return sum / (salary.length - 2);
    
    }
}