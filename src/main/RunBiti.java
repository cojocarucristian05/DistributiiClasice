package main;

import java.util.ArrayList;
import java.util.Random;

public class RunBiti {

    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        ArrayList<Integer> biti = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            double p = random.nextDouble(1);
            System.out.println(p);
            if(p >= 0.5) {
                biti.add(1);
            } else {
                biti.add(0);
            }
        }

        int count = 0;
        if(biti.size() == 0) {
            count = 0;
            return;
        }

        if(biti.get(0) == 1) {
            count = 1;
        } else {
            count = 0;
        }

        for(int i = 0; i < biti.size(); i++) {
            System.out.print(biti.get(i) + " ");
        }

        for(int i = 1; i < biti.size(); i++) {
//            System.out.print(biti.get(i) + " ");
            if(biti.get(i) == 1 && biti.get(i-1) == 0) {
                count++;
            }
        }
        System.out.println("\ncount = " + count);
    }
}
