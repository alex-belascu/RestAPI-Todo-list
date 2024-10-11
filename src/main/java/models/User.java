package models;

import lombok.Setter;

public class User {

    @Setter
    private int id;
    @Setter
    private String role;
    @Setter
    private String name;
    @Setter
    private int age;
    @Setter
    private String email;
    @Setter
    private int companyId;

    public User(int id, String role, String name, int age, String email, int companyId) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.age = age;
        this.email = email;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getCompanyId() {
        return companyId;
    }
}
