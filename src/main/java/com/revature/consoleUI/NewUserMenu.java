package com.revature.consoleUI;

import com.revature.daos.UserDAO;
import com.revature.pojos.User;
import com.revature.services.ConsoleService;
import com.revature.services.UserService;

import java.util.Scanner;

/*
Console layer left incomplete. You can implement something like this in your P1, but we will be replacing it with
an API very soon.
*/


public class NewUserMenu extends View{
    private UserService service;
    public NewUserMenu() {
        viewName = "NewUser";
        consoleService = ConsoleService.getConsoleService();
        service = new UserService();
    }


    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========== New User ===========");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(username, email, password);
        service.saveUser(newUser);

        consoleService.navigate("MainMenu");

    }
}
