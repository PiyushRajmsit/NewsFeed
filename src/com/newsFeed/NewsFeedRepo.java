package com.newsFeed;

import com.newsFeed.content.Post;
import com.newsFeed.content.Reply;
import com.newsFeed.exception.PostDoesNotExist;
import com.newsFeed.exception.UserAlreadyExistsException;
import com.newsFeed.exception.UserDoesNotExist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsFeedRepo {

    private static NewsFeedRepo newsFeedRepoInstance;
    private Map<String, Users> usersList;
    private Map<Long, Post> postList;
    private Users activeUser;
    private List<Post> allPost;

    private NewsFeedRepo() {
        usersList = new HashMap<>();
        postList = new HashMap<>();
        allPost = new ArrayList<>();
    }

    public static synchronized NewsFeedRepo getInstance() {
        if (newsFeedRepoInstance == null) {
            newsFeedRepoInstance = new NewsFeedRepo();
        }
        return newsFeedRepoInstance;
    }

    public void addUser(Users user) throws UserAlreadyExistsException {
        if(usersList.containsKey(user.getName())){
           throw new UserAlreadyExistsException("User already Exists");
        }
        usersList.put(user.getName(),user);
        System.out.println(user.toString());
    }

    public void loginUser(String name) throws UserDoesNotExist {

        if(!usersList.containsKey(name)){
            throw new UserDoesNotExist("User Does Not Exists");
        }
        setActiveUser(usersList.get(name));
    }

    public void setActiveUser(Users activeUser) {
        this.activeUser = activeUser;
    }

    public Users getActiveUser() {
        return activeUser;
    }

    public Users getUser(String name) throws UserDoesNotExist {
        if(!usersList.containsKey(name)) {
            throw new UserDoesNotExist("User Does Not Exists");
        }
        return usersList.get(name);
    }

    public void createPost(Post post){
        postList.put(post.getuId(),post);
        allPost.add(post);
        System.out.println("Post Successfully Created" + post.toString());
    }


    public Post getPost(Long id) throws PostDoesNotExist {
        if(!postList.containsKey(id)){
            throw new PostDoesNotExist("Post Does Not Exist");
        }
        return postList.get(id);
    }

    public List<Post>  getAllPost(){
        List<Post> allPost = new ArrayList<>(postList.values());
        return allPost;
    }

}
