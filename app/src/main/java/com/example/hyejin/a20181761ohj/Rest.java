package com.example.hyejin.a20181761ohj;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by guswn_000 on 2017-04-06.
 */

public class Rest implements Parcelable
{
    private String name;
    private String tel;
    private ArrayList<String> place;
    private String homepage;
    private String date;
    private int categorynum;

    public Rest(String name, String tel, String homepage, int categorynum)
    {
        this.name = name;
        this.tel = tel;
        this.homepage = homepage;
        this.categorynum = categorynum;
        place = new ArrayList<String>();
    }


    protected Rest(Parcel in) {
        name = in.readString();
        tel = in.readString();
        place = in.createStringArrayList();
        homepage = in.readString();
        date = in.readString();
        categorynum = in.readInt();
    }

    public static final Creator<Rest> CREATOR = new Creator<Rest>() {
        @Override
        public Rest createFromParcel(Parcel in) {
            return new Rest(in);
        }

        @Override
        public Rest[] newArray(int size) {
            return new Rest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(tel);
        dest.writeStringList(place);
        dest.writeString(homepage);
        dest.writeString(date);
        dest.writeInt(categorynum);
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getmenu1()
    {
        return place.get(0);
    }
    public String getmenu2()
    {
        return place.get(1);
    }
    public String getmenu3()
    {
        return place.get(2);
    }

    public String getHomepage() {
        return homepage;
    }

    public String getDate() {
        return date;
    }

    public int getCategorynum() {
        return categorynum;
    }

    public String printmenu(){
        String str = place.get(0) + ", " + place.get(1) + ", " +place.get(2);
        return str;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMenu(String item) {
        place.add(item);
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategorynum(int categorynum) {
        this.categorynum = categorynum;
    }

}

