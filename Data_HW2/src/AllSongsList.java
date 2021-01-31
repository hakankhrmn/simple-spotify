public class AllSongsList {

    private Song head;
    private Song tail;

    public Song getHead(){
        return head;
    }

    AllSongsList(PersonList personList){

        Person pointer = personList.getHead();
        while(pointer!=null){

            Song songPointer = pointer.songList.head;
            while(songPointer!=null){

                this.add(songPointer.songName);

                songPointer=songPointer.next;
            }

            pointer=pointer.next;
        }
    }

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
            }
        }
    }
    public boolean isEmpty(){
        if(this.head == null) {
            return true;
        }else{
            return false;
        }
    }

    public boolean contains(String name) {

        boolean exist = false;
        Song pointer = head;
        while (pointer != null) {
            if (pointer.songName.equalsIgnoreCase(name)) {
                pointer.count++;
                exist = true;

            }
            pointer = pointer.next;
        }
        return exist;
    }

    public void PrintMostThree(){
        this.sort();
        int count=0;
        Song pointer = head;
        while((pointer!=null)&&(count<3)){
            System.out.println(pointer.songName);
            pointer=pointer.next;
            count++;

        }


    }
    public void PrintList(){
        Song pointer = head;
        while(pointer!=null){
            System.out.println(pointer.songName);
            pointer=pointer.next;
        }
    }


    public void sort(){
        //Node current will point to head
        Song current = head, index = null;
        int tempCount;
        String tempName;

        if(head == null) {
            return;
        }
        else {
            while(current != null) {
                //Node index will point to node next to current
                index = current.next;

                while(index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if(current.count < index.count) {

                        tempName = current.songName;
                        current.songName=index.songName;
                        index.songName=tempName;

                        tempCount = current.count;
                        current.count = index.count;
                        index.count = tempCount;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
