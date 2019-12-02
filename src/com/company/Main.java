package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static ArrayList<RandomSample> list = new ArrayList<RandomSample>();

    public static void main(String[] args) {
        paradox();
    }

    private static void paradox(){
        int inputMin = 2;
        int inputMax = 50;

        try{
            System.out.println("Min value of n: ");
            inputMin = getNumber();
            System.out.println("Max value of n: ");
            inputMax = getNumber();
            if(inputMin > inputMax) throw new Exception();
        }
        catch (InputMismatchException ex){
            System.out.println("Number n must be greater than one!");
            return;
        }
        catch (Exception ex){
            System.out.println("Max value must be less than min value!");
            return;
        }

        System.out.println("Generating...");
        generateRandomSamples(inputMin, inputMax);
        for(RandomSample x: list) {
            System.out.println(x.toString());
        }
    }

    /*
    * Generates random groups of people (samples)
    * in which the number of people is from min_n to max_n
    */
    private static void generateRandomSamples(int min_n, int max_n){
		for(int i = min_n; i < max_n; i++){
			RandomSample randomSample = new RandomSample(i);
			randomSample.generate(20000);
			list.add(randomSample);
		}
	}

    /*
    * Get the correct number from user
    */
	private static int getNumber(){
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if(input <= 0){
			throw new InputMismatchException();
		}
		return input;
	}
}
