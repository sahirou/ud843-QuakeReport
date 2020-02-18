package com.example.android.quakereport;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link EarthQuake} represents ...
 * To allow EarthQuake custom objects to be parsed to another component, they need to implement
 * the android.os.Parcelable interface.
 */
public class EarthQuake implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public EarthQuake createFromParcel(Parcel in) {
            return new EarthQuake(in);
        }

        public EarthQuake[] newArray(int size) {
            return new EarthQuake[size];
        }
    };

    //Attributes

    /**
     * Place.
     */
    private String mPlace;

    /**
     * Date.
     */
    private String mDate;

    /**
     * Magnitude.
     */
    private double mMagnitude;

    /**
     * Constructor, for creating new EarthQuake objects
     *
     * @param place     is the
     * @param date      is the
     * @param magnitude is the
     */
    public EarthQuake(String place, String date, double magnitude) {
        this.mPlace = place;
        this.mDate = date;
        this.mMagnitude = magnitude;
    }

    // Define Getters and Setters

    public EarthQuake(Parcel in) {
        this.mPlace = in.readString();
        this.mDate = in.readString();
        this.mMagnitude = in.readDouble();
    }

    /**
     * Get place.
     */
    public String getPlace() {
        return mPlace;
    }

    /**
     * Set place.
     */
    public void setPlace(String place) {
        this.mPlace = place;
    }

    /**
     * Get date.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Set date.
     */
    public void setDate(String date) {
        this.mDate = date;
    }

    /**
     * Get magnitude
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Get magnitude
     */
    public void setMagnitude(double magnitude) {
        this.mMagnitude = magnitude;
    }


    // Parcelling part

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPlace);
        dest.writeString(this.mDate);
        dest.writeDouble(this.mMagnitude);
    }

    @Override
    public String toString() {
        return "EarthQuake{" +
                "place='" + mPlace + '\'' +
                ", date='" + mDate + '\'' +
                ", magnitude='" + mMagnitude + '\'' +
                '}';
    }
}