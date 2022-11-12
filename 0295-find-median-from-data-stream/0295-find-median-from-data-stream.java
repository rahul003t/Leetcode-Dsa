class MedianFinder {
    PriorityQueue<Integer> sh = new PriorityQueue<>();
    PriorityQueue<Integer> lh = new PriorityQueue<>();
        
    public void addNum(int num) 
    {
        lh.add(-num);
        sh.add(-lh.poll());
        
        if (sh.size() > lh.size())
            lh.add(-sh.poll());
    }
    
    public double findMedian() 
    {
        if (sh.size() == lh.size()) 
            return (sh.peek() - lh.peek()) / 2.0;
        return -lh.peek();
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */