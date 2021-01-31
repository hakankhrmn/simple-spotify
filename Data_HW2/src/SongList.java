public class SongList {
    public Song head;

    SongList(){}

    public void add(String name){
        if (this.contains(name)){
            return;
        }else {

            Song new_node = new Song(name) ;

            //if the LinkedList is empty
            if(this.isEmpty()) {
                this.head = new_node;
            }

            //traverse through the last node
            else {
                Song last = this.head;
                while(last.next != null) {

                    last = last.next;
                }
                last.next = new_node;
                new_node.prev=last;

            }
        }
    }
    public void remove(String song){

        Song pointer = head;

        while(pointer!=null){
            if(pointer.songName.equalsIgnoreCase(song)){
                if(pointer==head){
                    head=head.next;
                }else if (pointer.next!=null){
                    pointer.prev.next=pointer.next.next;
                }else if (pointer.next==null){
                    pointer.prev.next=null;
                }
            }
            pointer=pointer.next;
        }


    }
    public void PrintList(){
        Song pointer = head;
        while(pointer!=null){
            System.out.println(pointer.songName);
            pointer=pointer.next;
        }
    }
    public boolean isEmpty(){
        if(this.head == null) {
            return true;
        }else{
            return false;
        }
    }
    public boolean contains(String name){

        boolean exist=false;
        Song pointer = head;
        while(pointer!=null){
            if(pointer.songName.equalsIgnoreCase(name))
            {
                exist= true;

            }
            pointer=pointer.next;
        }
        return exist;

    }
}
