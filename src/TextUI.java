import java.util.Scanner;

    public class TextUI {
        private static Scanner sc = new Scanner(System.in);

        public String getUserInput(String prompt){
            System.out.println(prompt);
            return sc.nextLine();
        }
        public void showMessage(String message){
            System.out.println(message);
        }
        public int promptForPhone(){
            System.out.println("Phone Number: ");
            return sc.nextInt();// indtil nu

        }
        public String promptForMail(){
            System.out.println("Mail: ");
            return sc.nextLine(); // indtil nu

        }
    }
