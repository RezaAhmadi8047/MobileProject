package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile implements Parcelable {
    private String valueName;
    private String valueFamily;
    private String valuePhone;
    private String valueEmail;

    public UserProfile(String name, String family, String phone, String email) {
        this.valueName = name;
        this.valueFamily = family;
        this.valuePhone = phone;
        this.valueEmail = email;
    }

    public UserProfile(String name, String family, String phone) {
        this.valueName = name;
        this.valueFamily = family;
        this.valuePhone = phone;
        this.valueEmail = null;
    }

    // --- Parcelable constructor ---
    protected UserProfile(Parcel in) {
        valueName = in.readString();
        valueFamily = in.readString();
        valuePhone = in.readString();
        valueEmail = in.readString();
    }

    // --- write values to Parcel ---
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(valueName);
        dest.writeString(valueFamily);
        dest.writeString(valuePhone);
        dest.writeString(valueEmail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // --- Parcelable CREATOR ---
    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    // --- Getters and Setters ---
    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValueFamily() {
        return valueFamily;
    }

    public void setValueFamily(String valueFamily) {
        this.valueFamily = valueFamily;
    }

    public String getValuePhone() {
        return valuePhone;
    }

    public void setValuePhone(String valuePhone) {
        this.valuePhone = valuePhone;
    }

    public String getValueEmail() {
        return valueEmail;
    }

    public void setValueEmail(String valueEmail) {
        this.valueEmail = valueEmail;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "valueName='" + valueName + '\'' +
                ", valueFamily='" + valueFamily + '\'' +
                ", valuePhone='" + valuePhone + '\'' +
                ", valueEmail='" + valueEmail + '\'' +
                '}';
    }
}
