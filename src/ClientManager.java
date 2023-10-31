import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientManager {
    private ClientCreator CC = new ClientCreator();

    public File getExistingFile (Scanner input) {
        String filename;
        boolean fileExists = false;
        File clientsFile = null;

        System.out.println("Write the name of the file you would like to load: ");
        filename = input.nextLine();

        while (!fileExists) {
            clientsFile = new File("src/" + filename + ".txt");
            if (clientsFile.exists()) {
                fileExists = true;
            } else {
                System.out.print("File name you entered does not exists. Please enter a existing file name: ");
                filename = input.nextLine();
            }
        }
        //input.close();
        return clientsFile;
    }
    public ArrayList<Client> extractClientsFromFile(File clientsFile) {
        Client newClient = new Client();
        ArrayList<Client> clientsArrayList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(clientsFile);
            BufferedReader r = new BufferedReader(fileReader);
            int idCount = 0;
            String line;

            while ((line = r.readLine()) != null) {
                switch (line) {
                    case "[NOM]":
                        idCount++;
                        
                        newClient = new Client();
                        newClient.setID(idCount);
                        newClient.setName(r.readLine());
                        break;
                    case "[COGNOM]":
                        newClient.setSurname(r.readLine());
                        break;
                    case "[EDAT]":
                        newClient.setAge(Integer.parseInt(r.readLine()));
                        break;
                    case "[TELÈFON]":
                        newClient.setPhoneNumber(Integer.parseInt(r.readLine()));
                        break;
                    case "[EMAIL]":
                        newClient.setEmail(r.readLine());
                        break;
                    case "[FI_CLIENT]":
                        clientsArrayList.add(newClient);
                        newClient = null; // Reset newClient for the next client record.
                        break;
                    case "[FI_FITXER]":
                        return clientsArrayList;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clientsArrayList;
    }
    public void printClientInfo(ArrayList<Client> clientsArrayList, Scanner input) {
        int idToCheck = 0;
        Boolean idExists = false;

        System.out.print("Enter the ID of the client you want to view: ");

        try {
            idToCheck = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }


        for (Client c : clientsArrayList) {
            if (c.getID() == idToCheck)
                c.printInfo();
                idExists = true;

        }

        if (!idExists) {
            System.out.println("The client with ID '" + idToCheck + "' does not exists.");
        }
    }
    public void addClientToFile(File clientsFile, Scanner input) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(clientsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(clientsFile, true));
            String line, text = "";

            while ((line = reader.readLine()) != null) {
                if (line.equals("[FI_FITXER]")) {
                    continue;
                }
                System.out.println(line);
                writer.write(line + System.getProperty("line.separator"));
            }
            reader.close();

            CC.writeToFile("[CLIENT]", clientsFile);
            CC.writeToFile("[NOM]", clientsFile);
            System.out.print("2. Please, enter your name: ");
            text = input.nextLine();
            CC.writeToFile(text, clientsFile);

            // 3
            CC.writeToFile("[COGNOM]", clientsFile);
            System.out.print("3. Please, enter your surname: ");
            text = input.nextLine();
            CC.writeToFile(text, clientsFile);

            // 4
            CC.writeToFile("[EDAT]", clientsFile);
            System.out.print("4. Please, enter your age: ");
            text = input.nextLine();
            CC.writeToFile(text, clientsFile);

            // 5
            CC.writeToFile("[TELÈFON]", clientsFile);
            System.out.print("5. Please, enter your telephone number: ");
            text = input.nextLine();
            CC.writeToFile(text, clientsFile);

            // 6
            CC.writeToFile("[EMAIL]", clientsFile);
            System.out.print("6. Please, enter your email: ");
            text = input.nextLine();

            CC.writeToFile(text, clientsFile);
            CC.writeToFile("[FI_CLIENT]", clientsFile);
            CC.writeToFile("", clientsFile);


            System.out.println("Client successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to add the new client.");
        }
    }

    public static void main(String[] args) {
        ClientManager CM = new ClientManager();
        Scanner input = new Scanner(System.in);
        File clientsFile = null;
        int userCount = 0;
        ArrayList<Client> clientsArrayList = null;


        while (true) {
            System.out.println("");
            System.out.println("1. Select a file");
            System.out.println("2. Client count");
            System.out.println("3. Show client data");
            System.out.println("4. Add new client");
            System.out.println("5. Delete client");
            System.out.println("6. Modify client data");
            System.out.println("7. Exit");
            System.out.println("Please enter an operation (1-7).");


            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    clientsFile = CM.getExistingFile(input);
                    clientsArrayList = CM.extractClientsFromFile(clientsFile);

                    System.out.println("The file '" + clientsFile.getName() + "' has been successfully loaded.");

                    break;
                case 2:
                    System.out.println("The file '" + clientsFile.getName() + "' has " + clientsArrayList.size() + " clients.");
                    break;
                case 3:
                    CM.printClientInfo(clientsArrayList, input);
                    break;
                case 4:
                    CM.addClientToFile(clientsFile, input);
                    break;
                case 5:
                    // Modify client data
                    break;
                case 6:
                    // Exit
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
