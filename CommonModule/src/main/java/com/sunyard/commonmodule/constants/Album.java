package com.sunyard.commonmodule.constants;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @package name：com.sunyard.arouterdemo
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/15 10:12 AM
 */
public class Album implements Parcelable {

    /**
     * 负责反序列化
     */
    private static final Creator<Album> CREATOR = new Creator<Album>() {
        /**
         * 从序列化对象中，获取原始的对象
         * @param source
         * @return
         */
        @Override
        public Album createFromParcel(Parcel source) {
            return new Album(source);
        }

        /**
         * 创建指定长度的原始对象数组
         * @param size
         * @return
         */
        @Override
        public Album[] newArray(int size) {
            return new Album[0];
        }
    };


    private final String mId;
    private final String mCoverPath;
    private final String mDisplayName;
    private final long mCount;


    public Album(String id, String coverPath, String displayName, long count) {
        mId = id;
        mCoverPath = coverPath;
        mDisplayName = displayName;
        mCount = count;
    }

    Album(Parcel source) {
        mId = source.readString();
        mCoverPath = source.readString();
        mDisplayName = source.readString();
        mCount = source.readLong();
    }

    /**
     * 描述
     * 返回的是内容的描述信息
     * 只针对一些特殊的需要描述信息的对象,需要返回1,其他情况返回0就可以
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 序列化
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mCoverPath);
        dest.writeString(mDisplayName);
        dest.writeLong(mCount);
    }

    public String getmId() {
        return mId;
    }

    public String getmCoverPath() {
        return mCoverPath;
    }

    public String getmDisplayName() {
        return mDisplayName;
    }

    public long getmCount() {
        return mCount;
    }
}
