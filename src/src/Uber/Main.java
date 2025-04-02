package Uber;

import Uber.Service.RateLimiterService;

public class Main {
    public static void main(String[] args) {
        RateLimiterService rateLimiterService = new RateLimiterService();
        for(int i = 0; i<10; i++){
            System.out.println(rateLimiterService.rateLimiter(1)+" customer id 1");
            System.out.println(rateLimiterService.rateLimiter(2)+" customer id 2");
            System.out.println(rateLimiterService.rateLimiter(3)+" customer id 3");
            System.out.println(rateLimiterService.rateLimiter(4)+" customer id 4");
        }
    }
}
