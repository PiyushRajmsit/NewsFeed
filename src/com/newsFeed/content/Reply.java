package com.newsFeed.content;

import com.newsFeed.Users;

import java.time.LocalDateTime;

public class Reply extends Content{

    public Reply(String text, Users contentOwner) {
        super(text, contentOwner);
    }
}
