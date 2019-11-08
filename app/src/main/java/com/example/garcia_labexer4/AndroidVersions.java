package com.example.garcia_labexer4;

public class AndroidVersions {
    private int logo;
    private String oName, oCountry, oIndustry, oCeo;

    public AndroidVersions(int logo, String oName, String oCountry, String oIndustry, String oCeo) {
        this.logo = logo;
        this.oName = oName;
        this.oCountry = oCountry;
        this.oIndustry = oIndustry;
        this.oCeo = oCeo;
    }


    public int getLogo() {

        return logo;
    }

    public String getoName() {

        return oName;
    }

    public String getoCountry() {

        return oCountry;
    }

    public String getoIndustry() {

        return oIndustry;
    }

    public String getoCeo() {

        return oCeo;
    }
}
