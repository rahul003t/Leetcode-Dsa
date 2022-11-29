class RandomizedSet {
    HashMap<Integer, Integer> positions = new HashMap<>();
    int[] numbers = new int[400000];
    int lastIndex = -1;

    public RandomizedSet() {}
    
    public boolean insert(int val) {
        if (positions.containsKey(val)) return false;
        positions.put(val, ++lastIndex);
        numbers[lastIndex] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if (!positions.containsKey(val)) return false;
        int idx = positions.get(val);
        positions.remove(val);
        if (lastIndex != idx) {
            numbers[idx] = numbers[lastIndex];
            positions.put(numbers[idx], idx);
        }
        lastIndex--;
        return true;
    }
    
    public int getRandom() {
        int randomIdx = (int) (Math.random() * (lastIndex + 1));
        return numbers[randomIdx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */