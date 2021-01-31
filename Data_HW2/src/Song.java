public class Song {
    String songName;
    Song next;
    Song prev;
    int count;

    Song(String name){
        songName=name;
        next=null;
        prev=null;
        count=1;

    }

}
