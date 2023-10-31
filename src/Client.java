
public class Client {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int phoneNumber;
    private String email;

    public Client(int id, String name, String surname, int age, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Client() {
        this.id = 0;
        this.name = "John";
        this.surname = "Doe";
        this.age = 0;
        this.phoneNumber = 0;
        this.email = "johndoe@gmail.com";
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTelNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void printInfo() {
        System.out.println("======================");
        System.out.println("       CLIENT " + getID());
        System.out.println("======================");
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Age: " + getAge());
        System.out.println("Telephone Number: " + getTelNumber());
        System.out.println("Email: " + getEmail());
}
}
