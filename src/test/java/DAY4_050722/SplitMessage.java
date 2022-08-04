package DAY4_050722;

public class SplitMessage {
    public static void main(String[] args) {
        //declare string variable
        String splitMessage = "My name is John";
        // declare array of string
        String [] splitMessageArray = splitMessage.split( " ");

        //print out John to the counsole
        System.out.println("My first name is " + splitMessageArray[3]);
    }
}

