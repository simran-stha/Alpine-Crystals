package com.example.myapplication;

public class Crystals {


    private String crystalsName;

    // Image name (Without extension)
    private String imageName;
    private String birthmonth;

    public Crystals(String crystalsName, String imageName, String birthmonth) {
        this.crystalsName= crystalsName;
        this.imageName= imageName;
        this.birthmonth= birthmonth;
    }

    public String getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(String birthmonth) {
        this.birthmonth = birthmonth;
    }

    public String getCrystalsName() {
        return crystalsName;
    }

    public void setCrystalsName(String crystalsName) {
        this.crystalsName = crystalsName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString()  {
        return this.crystalsName+" (BirthMonth: "+ this.birthmonth+")";
    }
}