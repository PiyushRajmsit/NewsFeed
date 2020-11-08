package com.newsFeed;

import com.newsFeed.commands.CommandFactory;
import com.newsFeed.content.Post;
import com.newsFeed.content.Reply;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;
import com.newsFeed.exception.UserAlreadyExistsException;
import com.newsFeed.exception.UserDoesNotExist;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserDoesNotExist, PostDoesNotExist, UserAlreadyExistsException {
	// write your code here

        CommandFactory commandFactory = CommandFactory.getInstance();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String[] cmd = sc.nextLine().split("~");
            try {
                CommandFactory.getInstance().executeCommand(cmd);
            } catch (BadCommandException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }
    }
}
