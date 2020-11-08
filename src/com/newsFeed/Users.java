package com.newsFeed;

import com.newsFeed.content.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users extends DBObject {

    private String name;
    private String email;
    private List<Users> following;
    private List<Post> myPosts;
    private Map<Long,Users> userFollowMap;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
        following = new ArrayList<>();
        myPosts = new ArrayList<>();
        userFollowMap = new HashMap<>();
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
        userFollowMap.put(users.getuId(),users);
    }

    public boolean checkForFollower(Long id){
        if(userFollowMap.containsKey(id))
            return true;
        return false;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id =" + super.getuId() +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", myPosts=" + myPosts +
                '}';
    }
}
