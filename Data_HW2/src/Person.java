public class Person {

    String PersonName;
    Person next;
    SongList songList;

    Person(String name){
        PersonName=name;
        next=null;
        songList=new SongList();

    }

}
