import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ClientCreator { // Clase de la actividad 6
    private File file;
    private FileOutputStream FOS;
    private String filename;

    private boolean createFile() {
        try{
            FOS = new FileOutputStream(file);
            System.out.println("File with name: '" + this.filename + ".txt', has been created successfully.");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean loadFile() {
        Scanner input = new Scanner(System.in);
        boolean fileExists = true;

        while (fileExists) {
            this.file = new File("src/" + this.filename + ".txt");
            if (!this.file.exists()) {
                fileExists = false;
                return createFile();
            } else {
                System.out.println("File with name: '" + this.filename + ".txt', already exists.");
                System.out.print("Please enter a new file name: ");
                this.filename = input.nextLine();
            }
        }
        input.close();
        return false;
    }


    private boolean writeToFile(String text) {
        try {
            this.FOS.write(text.getBytes());
            this.FOS.write(10);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        ClientCreator App = new ClientCreator();
        Scanner input = new Scanner(System.in);
        String text;
        Boolean repeat = true, invalidOption = true;

        System.out.println();

        // 1

        System.out.print("1. Please, enter the file name: ");
        App.filename = input.nextLine();
        repeat = App.loadFile();
        App.writeToFile("[INICI_FITXER]");


        while (repeat) {
            invalidOption = true;

            // 2
            App.writeToFile("[CLIENT] [NOM]");
            System.out.print("2. Please, enter your name: ");
            text = input.nextLine();
            App.writeToFile(text);

            // 3
            App.writeToFile("[COGNOM]");
            System.out.print("3. Please, enter your surname: ");
            text = input.nextLine();
            App.writeToFile(text);

            // 4
            App.writeToFile("[EDAT]");
            System.out.print("4. Please, enter your age: ");
            text = input.nextLine();
            App.writeToFile(text);

            // 5
            App.writeToFile("[TELÈFON]");
            System.out.print("5. Please, enter your telephone number: ");
            text = input.nextLine();
            App.writeToFile(text);

            // 6
            App.writeToFile("[EMAIL]");
            System.out.print("6. Please, enter your email: ");
            text = input.nextLine();

            App.writeToFile(text);
            App.writeToFile("[FI_CLIENT]");
            App.writeToFile("");


            System.out.println("Client successfully added. Do you wish to add another client?");
            System.out.println("Please enter (Y) or (N)");
            text = input.nextLine();
            while (invalidOption) {
                if (text.equalsIgnoreCase("Y")) {
                    // El bucle principal se repetirá debido a que repeat = true.
                    invalidOption = false;

                } else if (text.equalsIgnoreCase("N")) {
                    System.out.print("Goodbye!");
                    App.writeToFile("[FI_FITXER]");
                    repeat = false;
                    invalidOption = false;

                } else {
                    System.out.println("Invalid input. Please enter (Y) or (N): ");
                    text = input.nextLine();
                }
            }
        }
    }
}
