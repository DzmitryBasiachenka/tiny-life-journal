package com.bsdim.tlj.admin;

import java.util.Scanner;

public class AdminStarter{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Hello, World!");
    System.out.format("Select a menu item.%n1)Add user.%n2)Display all users.%n3)Delete user.%n4)Exit%n");
    while (true) {
      int numder = in.nextInt();
      switch (numder){
        case 1:
          System.out.println("Hello user");
          continue;
        case 2:
          System.out.println("All users");
          continue;
        case 3:
          System.out.println("Delete user");
          continue;
        case 4:
            System.out.println("Bye-bye");
            System.exit( 0 );
        default:
          System.out.println("choose again");
          continue;
      }
    }
  }
}