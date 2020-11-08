package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.Users;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.UserDoesNotExist;

public class LoginCommand implements ICommand {


    private static LoginCommand loginCommandInstance;
    private NewsFeedRepo newsFeedRepo;

    private LoginCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized LoginCommand getInstance() {
        if (loginCommandInstance == null) {
            loginCommandInstance = new LoginCommand();
        }
        return loginCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, UserDoesNotExist {

        if(cmd.length != 2){
            throw new BadCommandException("Bad Command for Login!!");
        }
        newsFeedRepo.loginUser(cmd[1]);
    }
}
