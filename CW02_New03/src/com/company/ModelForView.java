package com.company;

public class ModelForView {
    private String ID;
    private String FirstName;
    private String LastName;
    private String Type;
    private String School;
    private String Date;
    private Integer Age;

    public String getID() {
        return ID;
    }

    public void setID(String memberID) {
        this.ID = memberID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String memberFirstName) {
        this.FirstName = memberFirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String memberLastName) {
        this.LastName = memberLastName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String memberType) {
        this.Type = memberType;
    }
    public String getSchool() {
        return School;
    }

    public void setSchool(String memberSchool) {
        this.School = memberSchool;
    }
    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer memberAge) {
        this.Age = memberAge;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String memberDate) {
        this.Date = memberDate;
    }

}

