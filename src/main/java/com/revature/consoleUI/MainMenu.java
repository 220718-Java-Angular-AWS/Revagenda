package com.revature.consoleUI;

import com.revature.services.ConsoleService;

import java.util.Scanner;
/*
Console layer left incomplete. You can implement something like this in your P1, but we will be replacing it with
an API very soon.
*/
public class MainMenu extends View{
    public MainMenu() {
        viewName = "MainMenu";
        consoleService = ConsoleService.getConsoleService();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Main Menu ==========");
        System.out.println("N) New User \nU) Update User \nD) Delete User \nG) Get User \nA) Get all Users \n\nQ) Quit ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        switch(input) {
            case "N":
                System.out.println("Navigating...");
                consoleService.navigate("NewUser");
                break;
            case "U":
                consoleService.navigate("UpdateUser");
                break;
            case "D":
                consoleService.navigate("DeleteUser");
                break;
            case "G":
                consoleService.navigate("GetUser");
                break;
            case "A":
                consoleService.navigate("GetAllUsers");
                break;
            case "Q":
                consoleService.quit();
                break;
        }

    }
}
