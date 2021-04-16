package com.company;
import java.util.Scanner;

public class Main {
    private static void swap(int array[][], int i1, int i2, int column){
        array[i1][column] = array[i1][column] + array[i2][column];
        array[i2][column] = array[i1][column] - array[i2][column];
        array[i1][column] = array[i1][column] - array[i2][column];
    }

    public static void main(String[] args) {
        int m, n;
	    System.out.println("import length");
	    Scanner in =  new Scanner(System.in);
	    m = in.nextInt();
        System.out.println("import height");
        n = in.nextInt();
        int arr[][] =  new int[n][m];
        System.out.println("Would you like to fill array manually or randomly? (enter m or r)");
        String ans = in.next();
        if (ans.equals("m")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.println("import value of " + (j+1) + " column " + (i+1) + " row");
                    arr[i][j] = in.nextInt();
                    if (arr[i][j] > 200 | arr[i][j] < 1) {
                        System.out.println("Value is out of range! Try again");
                        j -= 1;
                    }
                }
            }
        }
        else if(ans.equals("r")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = 1 + (int) (Math.random() * 200);
                }
            }
        }
	    else {
	        System.out.println("You entered wrong character, restart the script");
        }
	    System.out.println("Initial array:");
	    for (int i = 0; i < arr.length; i++) {
	        System.out.println();
	        for (int j = 0; j < arr[i].length; j++) {
	            System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println("Sorted array:");
//	    System.out.println(arr.length + " " + arr[0].length);
	    for (int i = 0; i < arr[0].length; i++) {
	        for (int j = 0; j < arr.length; j++) {
	            for (int k = 1; k < (arr.length - j); k++) {
	                if (arr[k - 1][i] < arr[k][i]) {
	                    swap(arr, k - 1, k, i);
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
