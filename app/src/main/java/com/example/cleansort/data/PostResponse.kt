package com.example.cleansort.data

import android.os.Parcel
import android.os.Parcelable

data class PostResponse(
    val id: Int,
    val username: String,
    val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(username)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostResponse> {
        override fun createFromParcel(parcel: Parcel): PostResponse {
            return PostResponse(parcel)
        }

        override fun newArray(size: Int): Array<PostResponse?> {
            return arrayOfNulls(size)
        }
    }
}