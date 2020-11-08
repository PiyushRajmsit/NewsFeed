package com.newsFeed.commands;

import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;
import com.newsFeed.exception.UserAlreadyExistsException;
import com.newsFeed.exception.UserDoesNotExist;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand {


    private static CommandFactory commandFactoryInstance;
    private Map<String,ICommand> commandMap;


    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("Signup",SignupCommand.getInstance());
        commandMap.put("Login",LoginCommand.getInstance());
        commandMap.put("UpVote",UpVoteCommand.getInstance());
        commandMap.put("DownVote",DownVoteCommand.getInstance());
        commandMap.put("Post",PostCommand.getInstance());
        commandMap.put("Reply",ReplyCommand.getInstance());
        commandMap.put("Follow_User",FollowCommand.getInstance());
        commandMap.put("ShowNewsFeed",ShowNewsFeed.getInstance());
    }

    public static synchronized CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, PostDoesNotExist, UserAlreadyExistsException, UserDoesNotExist {
        if(!commandMap.containsKey(cmd[0])) {
            throw new BadCommandException("InCorrect/Illegal Command ->" + cmd[0]);
        }
        commandMap.get(cmd[0]).executeCommand(cmd);
    }
}
