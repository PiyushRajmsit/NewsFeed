package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.content.Post;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;

public class DownVoteCommand implements ICommand {


    private static DownVoteCommand downVoteCommandInstance;
    private NewsFeedRepo newsFeedRepo;

    private DownVoteCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized DownVoteCommand getInstance() {
        if (downVoteCommandInstance == null) {
            downVoteCommandInstance = new DownVoteCommand();
        }
        return downVoteCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, PostDoesNotExist {
        if(cmd.length != 2){
            throw new BadCommandException("Bad Command Exception");
        }
        Long id = Long.valueOf(cmd[1]);
        Post post = newsFeedRepo.getPost(id);
        post.addDownVotes();
    }
}
