package 구현;

import java.util.*;

public class Solution_2018kakao_캐시{
    static class Solution {
        public int solution(int cacheSize, String[] cities) {

            Deque<String> dq = new LinkedList<>();

            int time = 0;
            for(String city : cities){
                city = city.toLowerCase();
                if(dq.contains(city)){
                    dq.remove(city);
                    dq.add(city);
                    time+=1;
                }else{
                    if(cacheSize != 0 && dq.size() == cacheSize) {
                        dq.poll();
                    }
                    if(dq.size() < cacheSize) dq.add(city);
                    time+= 5;
                }

            }

            return time;
        }
    }
}
