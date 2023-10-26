package org.example;

public class Patient {
    private int ID;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;

    public Patient(int ID, String name, int age, String gender, String phoneNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email=email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String toString() {
        return "PatientId: " + ID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }


}