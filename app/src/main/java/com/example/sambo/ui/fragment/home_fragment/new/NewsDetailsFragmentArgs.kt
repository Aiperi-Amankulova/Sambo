package com.example.sambo.ui.fragment.home_fragment.new

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.sambo.data.model.home_cards.RowsItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class NewsDetailsFragmentArgs(
    val details: RowsItem? = null
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(RowsItem::class.java)) {
            result.putParcelable("details", this.details as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(RowsItem::class.java)) {
            result.putSerializable("details", this.details as Serializable?)
        }
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): NewsDetailsFragmentArgs {
            bundle.setClassLoader(NewsDetailsFragmentArgs::class.java.classLoader)
            val __details : RowsItem?
            if (bundle.containsKey("details")) {
                if (Parcelable::class.java.isAssignableFrom(RowsItem::class.java) ||
                    Serializable::class.java.isAssignableFrom(RowsItem::class.java)) {
                    __details = bundle.get("details") as RowsItem?
                } else {
                    throw UnsupportedOperationException(RowsItem::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
            } else {
                __details = null
            }
            return NewsDetailsFragmentArgs(__details)
        }
    }
}
