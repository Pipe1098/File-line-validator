package com.example.taller.procesador.archivo.Model;

public class Persona {

    private String Index;
    private String User;
    private String Name;
    private String Sex;
    private String Email;
    private String Phone;
    private String DateBirth;
    private String JobTitle;

    public Persona(String index, String user, String name, String sex, String email, String phone, String dateBirth, String jobTitle) {
        Index = index;
        User = user;
        Name = name;
        Sex = sex;
        Email = email;
        Phone = phone;
        DateBirth = dateBirth;
        JobTitle = jobTitle;
    }

    public String getIndex() {
        return Index;
    }

    public String getUser() {
        return User;
    }

    public String getName() {
        return Name;
    }

    public String getSex() {
        return Sex;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getDateBirth() {
        return DateBirth;
    }

    public String getJobTitle() {
        return JobTitle;
    }


    public String toString() {
        return "Persona{" +
                "Index='" + Index + '\'' +
                ", User='" + User + '\'' +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", DateBirth='" + DateBirth + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                '}';
    }
}
