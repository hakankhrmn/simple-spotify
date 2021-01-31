public class PersonList {

    private Person head;

    public Person getHead(){
        return head;
    }


    PersonList(){}

    public void add(String name){
        if (this.contains(name)){
            return;
        }else {
            Person new_node = new Person(name) ;

            //if the LinkedList is empty
            if(this.isEmpty()) {
                this.head = new_node;
            }

            //traverse through the last node
            else {
                Person last = this.head;
                while(last.next != null) {

                    last = last.next;
                }
                last.next = new_node;

            }
        }
    }

    public void PrintList(){
        Person pointer = head;
        while(pointer!=null){
            System.out.println(pointer.PersonName);
            pointer=pointer.next;
        }
    }

    public Person getPerson(String name){
        Person person=null;
        person=head;
        Person pointer = null;
        pointer=head;
        while(pointer!=null){
            if (pointer.PersonName.equalsIgnoreCase(name)){
                person=pointer;
            }
            pointer=pointer.next;
        }
        return person;
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
        Person pointer = head;
        while(pointer!=null){
            if(pointer.PersonName.equalsIgnoreCase(name))
            {
                exist= true;

            }
            pointer=pointer.next;
        }
        return exist;

    }

}
