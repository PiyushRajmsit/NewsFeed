package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.Users;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.UserAlreadyExistsException;

public class SignupCommand implements ICommand {
    private static SignupCommand signupCommandInstance;
    private NewsFeedRepo newsFeedRepo;
    private SignupCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized SignupCommand getInstance() {
        if (signupCommandInstance == null) {
            signupCommandInstance = new SignupCommand();
        }
        return signupCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, UserAlreadyExistsException {

        if(cmd.length != 3)
        {
            throw new BadCommandException("Incorrect Command Format");
        }
        String name = cmd[1];
        String email = cmd[2];
        newsFeedRepo.addUser(new Users(name,email));
    }
}
