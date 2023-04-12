package models;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;

    public User(){}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password, String name) {
//        this.email = email;
//        this.password = password;
        setEmail(email);
        setPassword(password);
        setName(name);
    }

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public void setEmail(String email) {
        if(email != null)
            this.email = email;
    }
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public void setPassword(String password) {
        if(password != null)
            this.password = password;
    }
    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
