package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.content.Post;
import com.newsFeed.exception.BadCommandException;

public class PostCommand implements ICommand {
    private static PostCommand postCommandInstance;
    private NewsFeedRepo newsFeedRepo;

    private PostCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized PostCommand getInstance() {
        if (postCommandInstance == null) {
            postCommandInstance = new PostCommand();
        }
        return postCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {

        if(cmd.length != 2){
            throw new BadCommandException("Incorrect Bad Command Exception");
        }
        String postContent = cmd[1];
        Post newPost = new Post(postContent,newsFeedRepo.getActiveUser());
        newsFeedRepo.createPost(newPost);

    }
}
