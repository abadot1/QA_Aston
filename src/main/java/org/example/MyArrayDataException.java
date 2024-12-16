package org.example;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j){
        super("Некорректные данные в ячейке " + i + ", " + j);
    }
}
