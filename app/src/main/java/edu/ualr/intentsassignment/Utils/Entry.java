package edu.ualr.intentsassignment.Utils;

import android.os.Parcel;
import android.os.Parcelable;

public class Entry implements Parcelable {
    private String person_first_name;
    private String person_last_name;
    private String email;
    private String phone_number;
    private String website;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson_first_name() {
        return person_first_name;
    }
    public void setPerson_first_name(String person_first_name) {
        this.person_first_name = person_first_name;
    }
    public String getPerson_last_name() {
        return person_last_name;
    }
    public void setPerson_last_name(String person_last_name) {
        this.person_last_name = person_last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public Entry(String person_first_name, String person_last_name, String email_address, String phone_number, String website, String address) {
        this.person_first_name = person_first_name;
        this.person_last_name = person_last_name;
        this.email = email_address;
        this.phone_number = phone_number;
        this.website = website;
        this.address = address;
    }

    protected Entry(Parcel in) {
        person_first_name = in.readString();
        person_last_name = in.readString();
        email = in.readString();
        phone_number = in.readString();
        website = in.readString();
        address = in.readString();
    }

    public static final Creator<Entry> CREATOR = new Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(person_first_name);
        dest.writeString(person_last_name);
        dest.writeString(email);
        dest.writeString(phone_number);
        dest.writeString(website);
        dest.writeString(address);
    }
}
