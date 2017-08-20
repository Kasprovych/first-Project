package twitter.models;

import java.util.Date;

/**
 * Created by olehstefaniv on 19.08.17.
 */
public class HashTag {

    private String hashtag;

    private Date date;

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
