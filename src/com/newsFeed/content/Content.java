package com.newsFeed.content;

import com.newsFeed.DBObject;
import com.newsFeed.Users;

import java.sql.Time;
import java.time.LocalDateTime;

public abstract class Content extends DBObject {
    private String text;
    private final LocalDateTime localDateTime;
    private final Users contentOwner;

    public Content(String text, Users contentOwner) {
        this.text = text;
        this.localDateTime = LocalDateTime.now().plusDays(this.getuId());
        this.contentOwner = contentOwner;

    }

    public String getText() {
        return text;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Users getContentOwner() {
        return contentOwner;
    }


    @Override
    public String toString() {
        return "Content{" +
                "id = " + super.getuId() +
                ", text='" + text + '\'' +
                ", localDateTime=" + localDateTime +
                ", contentOwner=" + contentOwner.getName() +
                '}';
    }

}
