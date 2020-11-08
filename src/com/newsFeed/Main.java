package com.newsFeed;

import com.newsFeed.commands.CommandFactory;
import com.newsFeed.exception.BadCommandException;
import com.newsFeed.exception.PostDoesNotExist;
import com.newsFeed.exception.UserAlreadyExistsException;
import com.newsFeed.exception.UserDoesNotExist;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserDoesNotExist, PostDoesNotExist, UserAlreadyExistsException {
	// write your code here
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
