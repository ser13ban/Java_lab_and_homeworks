package org.example;

public class Actor {
    String stageName;
    String country;
    String dateOfBirth;

    public Actor() {
    }

    public Actor(String stageName, String dateOfBirth, String country) {
        this.stageName = stageName;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
