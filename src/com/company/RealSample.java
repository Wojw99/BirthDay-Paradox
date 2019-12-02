package com.company;

import java.util.ArrayList;

/*
* The class stores data about people's date of birth and randomly groups
* data to get the probability of two people with the same date of birth.
* */
public class RealSample {
    private int groupLength;
    private ArrayList<String> peopleList;
    private double probability;
    private String dataPath;

    public RealSample(int groupLength, String dataPath){
        this.probability = 0;
        this.groupLength = groupLength;
    }


}
