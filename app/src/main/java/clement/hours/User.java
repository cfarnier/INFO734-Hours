package clement.hours;

public class User {

    private String name;
    private String pass;
    private String startDate;

    /*
     * Constructor
     */
    public User(String name, String pass) {
        setName(name);
        setPass(pass);
    }

    /*
     * Getters & Setters
     */
    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String date) {
        this.startDate = date;
    }
}
