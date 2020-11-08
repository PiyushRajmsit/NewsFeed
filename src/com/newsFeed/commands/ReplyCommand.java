package com.newsFeed.commands;

import com.newsFeed.NewsFeedRepo;
import com.newsFeed.Users;
import com.newsFeed.content.Post;
import com.newsFeed.content.Reply;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;

public class ReplyCommand implements ICommand {

    private static ReplyCommand replyCommandInstance;
    private NewsFeedRepo newsFeedRepo;

    private ReplyCommand() {
        newsFeedRepo = NewsFeedRepo.getInstance();
    }

    public static synchronized ReplyCommand getInstance() {
        if (replyCommandInstance == null) {
            replyCommandInstance = new ReplyCommand();
        }
        return replyCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, PostDoesNotExist {
        if(cmd.length != 3)
            throw new BadCommandException("Bad Command Exception");

        Long id = Long.valueOf(cmd[1]);
        Post post = newsFeedRepo.getPost(id);
        String content = cmd[2];
        Reply reply = new Reply(content,newsFeedRepo.getActiveUser());
        post.addReply(reply);
    }
}
