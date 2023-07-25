package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {
    public Menu(){
        super();
    }
    public int getUserChoice(){
        int choice =0, i;
        System.out.println();
        for(i=0;i<this.size();i++){
            System.out.println( (i+1) + "_" + this.get(i));
        }
        System.out.print("Select an option: 1.." + i + ":");
        Scanner sc = new Scanner(System.in);
        choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
}
