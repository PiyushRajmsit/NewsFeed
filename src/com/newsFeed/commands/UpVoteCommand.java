package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.content.Post;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;

public class UpVoteCommand implements ICommand {
    private static UpVoteCommand upVoteCommandInstance;
    private NewsFeedRepo newsFeedRepo;
    private UpVoteCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized UpVoteCommand getInstance() {
        if (upVoteCommandInstance == null) {
            upVoteCommandInstance = new UpVoteCommand();
        }
        return upVoteCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, PostDoesNotExist {
        if(cmd.length != 2){
            throw new BadCommandException("Bad Command Exception");
        }
        Long id = Long.valueOf(cmd[1]);
        Post post = newsFeedRepo.getPost(id);
        post.addUpVotes();
    }
}
