import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PersonList personList= new PersonList();

        String command="";

        do{
            String personName="";
            String songName="";

            Scanner obj = new Scanner(System.in);
            String line = obj.nextLine();
            String[] lineArr=line.split(" ");
            if (lineArr.length!=0){
                command =lineArr[0];
                if(lineArr.length>=2){
                    personName=lineArr[1];
                    if (lineArr.length>2){
                        for(int i=2;i<lineArr.length;i++) {
                            songName += lineArr[i] + " ";
                        }
                    }
                }
            }else {
                System.out.println("enter a command");
            }


            switch (command){
                case "C":
                    if (personList.contains(personName)){
                        System.out.println("The name is already exists !");

                    }else {
                        personList.add(personName);
                        System.out.println("Successful");
                    }

                    break;
                case "S":
                    if (!personList.contains(personName)) {
                        personList.add(personName);
                    }
                    personList.getPerson(personName).songList.add(songName);
                    System.out.println("Successful");

                    break;
                case "E":
                    if (personList.contains(personName)){
                        personList.getPerson(personName).songList.remove(songName);
                        System.out.println("Successful");

                    }else {
                        System.out.println("There is no person named "+personName);
                    }
                    break;

                case "L":

                    if(personList.getPerson(personName).songList.isEmpty()){
                        System.out.println("The person does not like any song");
                    }else{
                        personList.getPerson(personName).songList.PrintList();
                        System.out.println("Successful");
                    }

                    break;
                case "N":

                    if(personList.isEmpty()){
                        System.out.println("Couldn't find any person");
                    }else{
                        personList.PrintList();
                        System.out.println("Successful");
                    }

                    break;

                case "M":
                    AllSongsList Songs=new AllSongsList(personList);
                    Songs.PrintList();
                    System.out.println("Successful");
                    break;

                case "R":

                    AllSongsList songs=new AllSongsList(personList);
                    songs.PrintMostThree();
                    System.out.println("Successful");
                    break;

                case "Q":
                    return;

                default:

                    System.out.println("Please enter valid command!!");

                    break;
            }

        }while (command!="Q");

    }
}
