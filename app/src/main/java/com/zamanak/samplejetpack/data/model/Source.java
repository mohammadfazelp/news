package com.zamanak.samplejetpack.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by PIRI on 1/22/2019.
 */
public class Source implements Parcelable {

    private String name;

    protected Source(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
