// 380. Insert Delete GetRandom O(1) - 06.04.2025
import java.util.*;

class RandomizedSet {

    Set<Integer> set;
    ArrayList<Integer> list;
    Random rand;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)) list.add((Integer)val);
        return set.add(val);
    }
    
    public boolean remove(int val) {
        if(set.contains(val)) list.remove((Integer)val);
        return set.remove(val);
    }
    
    public int getRandom() {
        //Integer[] arr = set.toArray(new Integer[0]);

        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */