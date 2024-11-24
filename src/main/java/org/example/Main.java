package org.example;

import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        //1
        printThreeWords();

        //2
        checkSumSign();

        //3
        printColor();

        //4
        compareNumbers();

        //5
        System.out.println(checkSum(5, 7));

        //6
        checkNumber(-3);

        //7
        System.out.println(checkNumber2(-3));

        //8
        printStr("Строка", 5);

        //9
        System.out.println(checkYear(2100));

        //10
        changeArr();

        //11
        fillArr();

        //12
        changeNumInArr();

        //13
        twoArr(10);

        //14
        createArr(10, 365);
    }

    public static void printThreeWords(){
        System.out.println("Задание 1");
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign() {
        System.out.println("Задание 2");
        int a = 15;
        int b = -43;
        if ((a + b) >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        System.out.println("Задание 3");
        int value = 141;
        if (value <= 0){
            System.out.println("Красный");
        } else if (value <= 100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        System.out.println("Задание 4");
        int a = 13;
        int b = 5;
        if(a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSum(int a, int b){
        System.out.println("Задание 5");
        if ((a + b) >= 10 && (a + b) <= 20){
            return true;
        } else {
            return false;
        }
    }

    public static void checkNumber(int a){
        System.out.println("Задание 6");
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean checkNumber2 (int a){
        System.out.println("Задание 7");
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void printStr (String str, int a) {
        System.out.println("Задание 8");
        for (int i = 0; i < a; i++){
            System.out.println(str);
        }
    }

    public static boolean checkYear(int a){
        System.out.println("Задание 9");
        if ((a % 4) != 0 | ((a / 100) % 4) != 0 ){
            return false;
        } else {
            return true;
        }
    }

    public static void changeArr(){
        System.out.println("Задание 10");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArr(){
        System.out.println("Задание 11");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1 + i;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeNumInArr(){
        System.out.println("Задание 12");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void twoArr(int n){
        System.out.println("Задание 13");
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            arr[i][i] = 1;
            arr[i][n - 1 -i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void createArr(int len, int initialValue){
        System.out.println("Задание 14");
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}