import javax.naming.CompositeName;

public class Client {
    String cName;
    String cSurname;
    int cAge;
    int cTelNumber;
    String cEmail;

    public Client(String cName, String cSurname, int cAge, int cTelNumber, String cEmail) {
        this.cName = cName;
        this.cSurname = cSurname;
        this.cAge = cAge;
        this.cTelNumber = cTelNumber;
        this.cEmail = cEmail;
    }

    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getcSurname() {
        return cSurname;
    }
    public void setcSurname(String cSurname) {
        this.cSurname = cSurname;
    }
    public int getcAge() {
        return cAge;
    }
    public void setcAge(int cAge) {
        this.cAge = cAge;
    }
    public int getcTelNumber() {
        return cTelNumber;
    }
    public void setcTelNumber(int cTelNumber) {
        this.cTelNumber = cTelNumber;
    }
    public String getcEmail() {
        return cEmail;
    }
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }
}
