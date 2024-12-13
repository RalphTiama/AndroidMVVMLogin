package com.example.androidmvvmlogin.ui.carousel

import android.os.Parcel
import android.os.Parcelable


data class ResultMovieMainModel(
    val artistId: Int,
    val artistName:String? = "",
    val artistViewUrl: String? = "",
    val artworkUrl100:String? = "",
    val artworkUrl30: String? = "",
    val artworkUrl60: String? = "",
    val collectionArtistId: Int,
    val collectionArtistViewUrl: String? = "",
    val collectionCensoredName: String? = "",
    val collectionExplicitness: String,
    val collectionHdPrice: Double,
    val collectionId: Int,
    val collectionName: String? = "",
    val collectionPrice: Double,
    val collectionViewUrl: String? = "",
    val contentAdvisoryRating: String,
    val country: String? = "",
    val currency:String? = "",
    val discCount: Int,
    val discNumber: Int,
    val hasITunesExtras: Boolean,
    val kind: String? = "",
    val longDescription: String? = "",
    val previewUrl: String? = "",
    val primaryGenreName:String? = "",
    val releaseDate: String? = "",
    val shortDescription:String? = "",
    val trackCensoredName:String? = "",
    val trackCount: Int,
    val trackExplicitness: String? = "",
    val trackHdPrice: Double,
    val trackHdRentalPrice: Double,
    val trackName: String? = "",
    val trackNumber: Int,
    val trackPrice: Double,
    val trackRentalPrice: Double,
    val trackTimeMillis: Int,
    val trackViewUrl:String? = "",
    val wrapperType: String? = "",
    var isLike: Boolean = false,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        artistId = parcel.readInt(),
        artistName = parcel.readString() ?: "",
        artistViewUrl = parcel.readString() ?: "",
        artworkUrl100 = parcel.readString() ?: "",
        artworkUrl30 = parcel.readString() ?: "",
        artworkUrl60 = parcel.readString() ?: "",
        collectionArtistId = parcel.readInt(),
        collectionArtistViewUrl = parcel.readString() ?: "",
        collectionCensoredName = parcel.readString() ?: "",
        collectionExplicitness = parcel.readString() ?: "",
        collectionHdPrice = parcel.readDouble(),
        collectionId = parcel.readInt(),
        collectionName = parcel.readString() ?: "",
        collectionPrice = parcel.readDouble(),
        collectionViewUrl = parcel.readString() ?: "",
        contentAdvisoryRating = parcel.readString() ?: "",
        country = parcel.readString() ?: "",
        currency = parcel.readString() ?: "",
        discCount = parcel.readInt(),
        discNumber = parcel.readInt(),
        hasITunesExtras = parcel.readByte() != 0.toByte(),
        kind = parcel.readString() ?: "",
        longDescription = parcel.readString() ?: "",
        previewUrl = parcel.readString() ?: "",
        primaryGenreName = parcel.readString() ?: "",
        releaseDate = parcel.readString() ?: "",
        shortDescription = parcel.readString() ?: "",
        trackCensoredName = parcel.readString() ?: "",
        trackCount = parcel.readInt(),
        trackExplicitness = parcel.readString() ?: "",
        trackHdPrice = parcel.readDouble(),
        trackHdRentalPrice = parcel.readDouble(),
        trackName = parcel.readString() ?: "",
        trackNumber = parcel.readInt(),
        trackPrice = parcel.readDouble(),
        trackRentalPrice = parcel.readDouble(),
        trackTimeMillis = parcel.readInt(),
        trackViewUrl = parcel.readString() ?: "",
        wrapperType = parcel.readString() ?: "",
        isLike = parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(artistId)
        parcel.writeString(artistName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeInt(collectionArtistId)
        parcel.writeString(collectionArtistViewUrl)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(collectionExplicitness)
        parcel.writeDouble(collectionHdPrice)
        parcel.writeInt(collectionId)
        parcel.writeString(collectionName)
        parcel.writeDouble(collectionPrice)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeInt(discCount)
        parcel.writeInt(discNumber)
        parcel.writeByte(if (hasITunesExtras) 1 else 0)
        parcel.writeString(kind)
        parcel.writeString(longDescription)
        parcel.writeString(previewUrl)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
        parcel.writeString(shortDescription)
        parcel.writeString(trackCensoredName)
        parcel.writeInt(trackCount)
        parcel.writeString(trackExplicitness)
        parcel.writeDouble(trackHdPrice)
        parcel.writeDouble(trackHdRentalPrice)
        parcel.writeString(trackName)
        parcel.writeInt(trackNumber)
        parcel.writeDouble(trackPrice)
        parcel.writeDouble(trackRentalPrice)
        parcel.writeInt(trackTimeMillis)
        parcel.writeString(trackViewUrl)
        parcel.writeString(wrapperType)
        parcel.writeByte(if (isLike) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ResultMovieMainModel> {
        override fun createFromParcel(parcel: Parcel): ResultMovieMainModel {
            return ResultMovieMainModel(parcel)
        }

        override fun newArray(size: Int): Array<ResultMovieMainModel?> {
            return arrayOfNulls(size)
        }
    }
}