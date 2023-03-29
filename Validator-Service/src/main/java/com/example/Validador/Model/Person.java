package com.example.Validador.Model;

public class Person {
    private String Index;
    private String User;
    private String Name;
    private String Sex;
    private String Email;
    private String Phone;
    private String DateBirth;
    private String JobTitle;

    public Person(String index, String user, String name,
                  String sex, String email, String phone,
                  String dateBirth, String jobTitle) {

        Index = index;
        User = user;
        Name = name;
        Sex = sex;
        Email = email;
        Phone = phone;
        DateBirth = dateBirth;
        JobTitle = jobTitle;
    }

    public String getEmail() {
        return Email;
    }

    public String getDateBirth() {
        return DateBirth;
    }

    public String getJobTitle() {
        return JobTitle;
    }
}
