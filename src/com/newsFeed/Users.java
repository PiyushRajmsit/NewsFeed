package com.newsFeed;

import com.newsFeed.content.Post;

import java.util.ArrayList;
import java.util.List;

public class Users extends DBObject {

    private String name;
    private String email;
    private List<Users> following;
    private List<Post> myPosts;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
        following = new ArrayList<>();
        myPosts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Users> getFollowing() {
        return following;
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public void addPost(Post mypost){
        myPosts.add(mypost);
    }
    public void followUser(Users users){
        following.add(users);
    }


}
