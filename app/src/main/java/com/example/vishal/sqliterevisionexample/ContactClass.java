package com.example.vishal.sqliterevisionexample;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactClass implements Parcelable {
    private String name;
    private int id;
    private String adds;
    private String sal;
    private String phone;

    public ContactClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    protected ContactClass(Parcel in) {
        name = in.readString();
        id = in.readInt();
        adds = in.readString();
        sal = in.readString();
        phone = in.readString();
    }

    public static final Creator<ContactClass> CREATOR = new Creator<ContactClass>() {
        @Override
        public ContactClass createFromParcel(Parcel in) {
            return new ContactClass(in);
        }

        @Override
        public ContactClass[] newArray(int size) {
            return new ContactClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(adds);
        dest.writeString(sal);
        dest.writeString(phone);
    }
}
