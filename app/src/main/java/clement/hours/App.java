package clement.hours;

import android.app.Application;

public class App extends Application {

    private User u;

    /*
     * Controllers
     */
    public void addUser(String name, String pass) {

        u = new User(name, pass);
    }

    /*
     * Getters & Setters
     */
    public String getNameUser() {
        return u.getName();
    }
    public void setNameUser(String name) {
        u.setName(name);
    }
    public String getPassUser() {
        return u.getPass();
    }
    public void setPassUser(String pass) {
        u.setPass(pass);
    }
    public String getStartdateSession() {
        return u.getStartDate();
    }
    public void setStartdateSession(String date) {
        u.setStartDate(date);
    }
}