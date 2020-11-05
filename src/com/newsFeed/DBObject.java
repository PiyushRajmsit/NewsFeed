package com.newsFeed;

public abstract class DBObject {

    private static long NEW_UID = 0;
    private final long uId;

    public DBObject() {
        this.uId = ++NEW_UID;
    }

    public long getuId() {
        return uId;
    }
}
