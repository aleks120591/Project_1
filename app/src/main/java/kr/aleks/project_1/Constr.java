package kr.aleks.project_1;

import java.util.UUID;

public class Constr {

    private UUID mId;
    private String mTitle;
    private int mImage;
    private String mGrowth;
    private String mDescription;
    private String mPlusTheIncrease;
    private String mTimer;

    public Constr() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getGrowth() {
        return mGrowth;
    }

    public void setGrowth(String growth) {
        mGrowth = growth;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPlusTheIncrease() {
        return mPlusTheIncrease;
    }

    public String getTimer() {
        return mTimer;
    }
}
