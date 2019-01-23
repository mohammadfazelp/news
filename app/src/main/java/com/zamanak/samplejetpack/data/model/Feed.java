package com.zamanak.samplejetpack.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.zamanak.samplejetpack.utils.Utility;

import java.util.List;

/**
 * Created by PIRI on 1/22/2019.
 */
public class Feed implements Parcelable {

    private transient long id;
    private String status;
    private long totalResults;
    private List<Article> articles;


    protected Feed(Parcel in) {
        id = Utility.getRandomNumber();
        status = in.readString();
        totalResults = in.readLong();
        articles = in.createTypedArrayList(Article.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(status);
        dest.writeLong(totalResults);
        dest.writeTypedList(articles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Feed> CREATOR = new Creator<Feed>() {
        @Override
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        @Override
        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
