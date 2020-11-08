package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.Users;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.UserDoesNotExist;

public class FollowCommand implements ICommand {

    private NewsFeedRepo newsFeedRepo;
    private static FollowCommand followCommandInstance;

    private FollowCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized FollowCommand getInstance() {
        if (followCommandInstance == null) {
            followCommandInstance = new FollowCommand();
        }
        return followCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, UserDoesNotExist {

        if(cmd.length != 2){
            throw new BadCommandException("Bad Command Exception");
        }
        Users users = newsFeedRepo.getUser(cmd[1]);
        newsFeedRepo.getActiveUser().followUser(users);
    }
}
