// 134. Gas Station - 05.27.2025
package leetcode;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if you start at a and stuck at b, cannot start at any station between a and b
        
        int station = 0;
        int fuel = 0;
        int numVisit = 0;
        int numStarts = 0;

        while(true) {
            fuel += gas[station];   // refuel
            numVisit++;
            
            if(numVisit == gas.length+1) return station;

            // Update gas
            fuel -= cost[station];

            // Cannot reach next station
            if(fuel < 0) {
                numStarts += numVisit;
                if(numStarts >= gas.length) return -1;
                fuel = 0;
                numVisit = 0;
            }

            // Update station
            station++;
            station %= gas.length;
            
        }

    }
}