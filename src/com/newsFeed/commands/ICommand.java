package com.newsFeed.commands;

import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;
import com.newsFeed.exception.UserAlreadyExistsException;
import com.newsFeed.exception.UserDoesNotExist;

public interface ICommand {

    public void executeCommand(String cmd[]) throws BadCommandException, UserAlreadyExistsException, UserDoesNotExist, PostDoesNotExist;
}
