package Uber.Service;
import Uber.Constants.Constant;
//import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    Map<Integer, Integer> customerhitMap = new HashMap<>();
    Map<Integer, Long> customerTimeMap = new HashMap<>();
    public boolean rateLimiter(int customerId) {
        if(!customerhitMap.containsKey(customerId)){
//            Pair newPair = new Pair(Constant.bucket-1, System.currentTimeMillis()+Constant.RefilTime);
            customerhitMap.put(customerId, Constant.bucket-1);
            customerTimeMap.put(customerId, System.currentTimeMillis()+Constant.RefilTime);
            return true;
        }else{
            if(customerhitMap.get(customerId)>0){
//                Pair p = new Pair(customerhitMap[customerId].getKey()-1, customerhitMap[customerId].getValue());
                customerhitMap.put(customerId, customerhitMap.get(customerId)-1);
//                customerTimeMap.put(customerId, System.currentTimeMillis()+;
                return true;
            }else{
                long currentTime = System.currentTimeMillis();
                if(currentTime>customerTimeMap.get(customerId)){
                    customerhitMap.put(customerId, Constant.bucket-1);
                    customerTimeMap.put(customerId, System.currentTimeMillis()+Constant.RefilTime);
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
