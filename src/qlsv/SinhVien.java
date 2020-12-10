/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv;

/**
 *
 * @author Admin
 */
public class SinhVien {

    private String ID;
    private String Name;
    private String Gender;
    private int Age;
    private String Email;
    private String Phone;

    public SinhVien() {
    }

    public SinhVien(String ID, String Name, String Gender, int Age, String Email, String Phone) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.Age = Age;
        this.Email = Email;
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
}
