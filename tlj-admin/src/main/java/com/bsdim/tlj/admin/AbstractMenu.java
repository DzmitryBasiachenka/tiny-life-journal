package com.bsdim.tlj.admin;

import java.util.Scanner;

public abstract class AbstractMenu {
    private Scanner scanner = new Scanner(System.in);

    public int performMenu(){
        showMenu();
        return getValue();
    }
    protected abstract void showMenu();
    protected int getValue(){
        return scanner.nextInt();
    }
}
