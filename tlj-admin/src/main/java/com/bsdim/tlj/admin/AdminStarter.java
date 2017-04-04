package com.bsdim.tlj.admin;

import com.bsdim.tlj.admin.menu.MainMenu;

public class AdminStarter {
  public static void main(String[] args) {
      MainMenu menu = new MainMenu();
      System.out.println(menu.selectMenu());
  }
}
