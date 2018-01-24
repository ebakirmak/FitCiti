package com.boshware.fitciti.JSONModel;

/**
 * Created by Emre on 4.1.2018.
 */

public class LocationInfoModel {
    private int Country;
    private int Province;
    private int Town;

    public void setCountry(int country) {
        Country = country;
    }

    public void setProvince(int province) {
        Province = province;
    }

    public void setTown(int town) {
        Town = town;
    }

    public int getCountry() {
        return Country;
    }

    public int getProvince() {
        return Province;
    }

    public int getTown() {
        return Town;
    }
}
