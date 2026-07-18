class User{
    int userId;
    HashSet <Integer> followers;
    LinkedList <Tweet> posts ;
    public User(int userId){
        this.userId = userId;
        followers = new HashSet<>(); ;
        posts = new LinkedList<>();
    }

    public void addTweet (int tweetId,int time){
        posts.addFirst(new Tweet(tweetId,time));
    }

    public void addFollower (int followeeId){
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}

class Tweet implements Comparable<Tweet>{
    int tweetId ;
    int time ;
    public Tweet(int tweetId,int time){
        this.tweetId=tweetId;
        this.time =time ;
    }

    @Override 
    public int compareTo(Tweet that){
        return that.time - this.time;
    }
}

class Twitter {
    Map<Integer,User> twitterUserMap = new HashMap<>(); 
    int timeCounter ;
    public Twitter() {
        this.twitterUserMap = new HashMap<>();
        this.timeCounter =0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!twitterUserMap.containsKey(userId)){
            User u = new User(userId);
            u.addTweet(tweetId,timeCounter);
            twitterUserMap.put(userId,u);
        }
        else{
            twitterUserMap.get(userId).addTweet(tweetId,timeCounter);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!twitterUserMap.containsKey(userId)){
           return new ArrayList<>();
        }
        PriorityQueue<Tweet> heap = new PriorityQueue<>();
        User user = twitterUserMap.get(userId);
        for(int follower : user.followers){
            int count = 0 ;
            for(Tweet followUserPost : twitterUserMap.get(follower).posts){
                heap.offer(followUserPost);
                count++;
                if(count>10){
                    break;
                }
            }
        }

        int count = 0 ;
        for(Tweet self : user.posts){
            heap.offer(self);
            count++;
            if(count>10){
                    break;
                }
        }

        List<Integer> res = new ArrayList<>();
        int index =0 ;
        while(!heap.isEmpty() && index<10){
            Tweet t = heap.poll();
            res.add(t.tweetId);
            index++;
        }
        return res ;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!twitterUserMap.containsKey(followerId)){
            User u = new User(followerId);
            twitterUserMap.put(followerId, u);
        }
        if(!twitterUserMap.containsKey(followeeId)){
            User u = new User(followeeId);
            twitterUserMap.put(followeeId, u);
        }
        twitterUserMap.get(followerId).addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!twitterUserMap.containsKey(followerId)){
            return ;
        }
        twitterUserMap.get(followerId).removeFollower(followeeId);
    }
}
