package ie.wit.models

import android.os.Parcelable
import android.widget.EditText
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewModel(
    var id: Long = 0,
    var name: String="",
    var location: String = "",
    var service: String ="",
    var amount2: Int = 0,
    var ratingmethod: String = "N/A",
    var amount: Int = 0) : Parcelable

