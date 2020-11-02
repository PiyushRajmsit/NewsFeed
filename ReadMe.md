# News Feed

#### Your aim is to write a console program that can simulate a social network.

Users have the following capabilities (command to be used in [ - ]):

* [post] A user can post a feed item.

* [follow] Users can follow other users.

* [reply] A user can comment on another user's feed item.

* [upvote/downvote] Upvote or downvote posts.

* [shownewsfeed] Any user can read his news feed. News items are sorted based on the following:

* Followed users: posts by followed users appear first.

* Score (= upvotes - downvotes): higher the better.

* Number of comments: higher the better.

* Timestamp: more recent the better.

### Bonus
* Allow users to comment on a comment and upvote/downvote a comment.

* Display time in language like 2m ago, 1 hr ago etc.

## Input and output
* The input should be taken in the form of statements. The statements should consist of commands and arguments. Commands can be words like ‘signup’, ‘newsfeed’, ‘upvote’ etc. Arguments can be separated from commands by special characters, something like ‘~’. As a result, a statement to reply to 

* post 005 can look something like

* reply~005~this is the reply text

* You may change the input-output format without changing the functionality to suit your needs.
You may hardcode the input in a driver function, have the names of the functions as the commands and the arguments of the commands as the arguments of the functions. It might look something like the following.

* reply(5, "this is the reply text");

### Sample
Input is in red, the output is blue. You need to print the output of shownewsfeed for a user, whenever he logs in.

> signup~lucious

> signup~albus

> signup~tom

> login~tom

> post~I am going to be the darkest dark wizard of all time

> post~I am lord Voldemort btw 3:)

> login~lucious

``` id: 002
(0 upvotes, 0 downvotes)
tom
I am lord Voldemort btw 3:)
1994-04-19 10:11 PM
```

```id: 001
(0 upvotes, 0 downvotes)
tom
I am going to be the darkest dark wizard of all time
1994-04-19 10:10 PM
```

> upvote~001

> follow~tom

> reply~001~I am with you dark lord!

> login~albus

``` id: 001
(1 upvote, 0 downvotes)
tom
I am going to be the darkest dark wizard of all time
1994-04-19 10:10 PM
        id: 003
        Lucious
        I am with you dark lord!
        1994-04-19 10:15 PM
```

```
 id: 002
(0 upvotes, 0 downvotes)
tom
I am lord Voldemort btw 3:)
1994-04-19 10:11 PM
```

> post~Happiness can be found, even in the darkest of times, if one only remembers to turn on the light

> follow~tom

> downvote~001

> downvote~002

> reply~002~LOL!

> shownewsfeed

```
id: 001
(1 upvote, 1 downvotes)
tom
I am going to be the darkest dark wizard of all time
1994-04-19 10:10 PM
        id: 003
        lucius
        I am with you dark lord!
1994-04-19 10:15 PM

id: 002
(0 upvotes, 1 downvotes)
tom
I am lord Voldemort btw 3:)
1994-04-19 10:11 PM
        id: 005
        albus
        LOL!
        1994-04-19 10:30 PM

id: 004
(0 upvotes, 0 downvotes)
albus
Happiness can be found, even in the darkest of times, if one only remembers to turn on the light
1994-04-19 10:28 PM
```

##Guidelines
* The code should handle edge cases properly and fail gracefully. Add suitable exception handling, wherever applicable.
Handle concurrency where needed.
* The code should have a good object-oriented design.
* The code should be readable, modular, testable, and extensible. Use intuitive names for your variables, methods, and classes.
It should be easy to add/remove functionality without rewriting a lot of code.
* Do not write monolithic code.
