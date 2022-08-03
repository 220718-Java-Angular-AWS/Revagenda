package com.revature.consoleUI;

import com.revature.services.ConsoleService;
/*
Console layer left incomplete. You can implement something like this in your P1, but we will be replacing it with
an API very soon.
*/
public abstract class View {
    protected String viewName;
    protected ConsoleService consoleService;


    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
