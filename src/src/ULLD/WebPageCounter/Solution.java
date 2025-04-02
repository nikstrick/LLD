package ULLD.WebPageCounter;

import java.util.concurrent.ConcurrentHashMap;

// use helper.print("") or helper.println("") for printing logs else logs will not be visible.
public class Solution implements Q06WebpageVisitCounterInterface {
    private Helper06 helper;
    ConcurrentHashMap<Integer,Integer> map;


    public Solution(){}

    public void init(int totalPages, Helper06 helper){
        this.helper=helper;
         helper.println("restaurant rating module initialized");
        this.map=new ConcurrentHashMap<>(totalPages);
        for(int i=0;i<totalPages;i++){
            map.put(i,0);
        }
    }

    // increment visit count for pageIndex by 1
    public void incrementVisitCount(int pageIndex) {
        if(map.containsKey(pageIndex)){
            map.put(pageIndex,map.get(pageIndex)+1);
        }
    }

    // return total visit count for a given page
    public int getVisitCount(int pageIndex) {
        return map.get(pageIndex);
    }
}

// uncomment below code in case you are using your local ide like intellij, eclipse etc and
// comment it back again back when you are pasting completed solution in the online CodeZym editor.
// if you don't comment it back, you will get "java.lang.AssertionError: java.lang.LinkageError"
// This will help avoid unwanted compilation errors and get method autocomplete in your local code editor.

 interface Q06WebpageVisitCounterInterface {
 void init(int totalPages, Helper06 helper);
 void incrementVisitCount(int pageIndex);
 int getVisitCount(int pageIndex);
 }

 class Helper06 {
 void print(String s){System.out.print(s);}
 void println(String s){System.out.println(s);}
 }