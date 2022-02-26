package fiek.example.movieapp;

public class UserModel {

    private int Id;
    private String name,lastName,Email,Password;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public UserModel(int id, String name, String lastName, String email, String password) {
        this.Id = id;
        this.name = name;
        this.lastName = lastName;
        this.Email = email;
        this.Password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
