class Solution {

public double champagneTower(int poured, int query_row, int query_glass) {
if (poured == 0)
return 0;

    List<Double> prevRow = new ArrayList<>(List.of((double) poured));

    while (query_row-- > 0) {
	    List<Double> currentRow = new ArrayList<Double>();
	    double champagneInEnds = Math.max(0, (prevRow.get(0) - 1) / 2);  // min champagne can be 0
        
	    currentRow.add(champagneInEnds); // first glass

	    for (int i = 1; i < prevRow.size(); i++)
		    currentRow.add(Math.max(0, (prevRow.get(i - 1) - 1) / 2) + // flow from top-left glass
					   Math.max(0, (prevRow.get(i) - 1) / 2));     // flow from top-right glass

	    currentRow.add(champagneInEnds); // last glass
	    prevRow = currentRow;
    }
    
    return Math.min(1, prevRow.get(query_glass)); // max champagne can be 1
}
}