package com.company;

import java.util.ArrayList;
import java.util.Random;

/*
* Class to generate group of random dates which stores probability of getting two same dates in the group
* */
public class RandomSample implements Comparable{
    private int groupLength;
    private double probability;

    public RandomSample(int groupLength){
        this.probability = 0;
        this.groupLength = groupLength;
    }

    public int getGroupLength() {
        return groupLength;
    }

    public double getProbability() {
        return probability;
    }

    /*
    * Checks if it has been generated two same dates in the Sample and returns probability
    * */
    public void generate(int attempts){
        int successes = 0;
        for (int i = 0; i < attempts; i++){
            if(twoSameDates()){
                successes++;
            }
        }
        double x = successes;
        double y = attempts;
        probability = x/y;
    }

    /*
    * Generates group of random dates and returns true if it has been two same dates in group
    * */
    private boolean twoSameDates(){
        ArrayList<String> dates = new ArrayList<String>();
        Random random = new Random();

        for (int i = 0; i < groupLength; i++){
            int day = random.nextInt(30)+1;
            int month = random.nextInt(12)+1;
            String date = String.valueOf(day)+"."+String.valueOf(month);

            if (dates.contains(date)){
                return true;
            }
            else{
                dates.add(date);
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Persons: " + groupLength + ", probability: " + probability;
    }

    @Override
    public int compareTo(Object o) {
        RandomSample randomSample = (RandomSample)o;
        return Integer.compare(this.groupLength, randomSample.getGroupLength());
    }
}

