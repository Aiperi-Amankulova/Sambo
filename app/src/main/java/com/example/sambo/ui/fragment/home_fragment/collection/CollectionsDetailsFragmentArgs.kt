package com.example.sambo.ui.fragment.home_fragment.collection

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.sambo.data.model.home_collections.RowsItem
import java.io.Serializable


data class CollectionsDetailsFragmentArgs(
    val collections: RowsItem? = null
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(RowsItem::class.java)) {
            result.putParcelable("collections", this.collections as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(RowsItem::class.java)) {
            result.putSerializable("collections", this.collections as Serializable?)
        }
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): CollectionsDetailsFragmentArgs {
            bundle.setClassLoader(CollectionsDetailsFragmentArgs::class.java.classLoader)
            val __collections : RowsItem?
            if (bundle.containsKey("collections")) {
                if (Parcelable::class.java.isAssignableFrom(RowsItem::class.java) ||
                    Serializable::class.java.isAssignableFrom(RowsItem::class.java)) {
                    __collections = bundle.get("collections") as RowsItem?
                } else {
                    throw UnsupportedOperationException(RowsItem::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
            } else {
                __collections = null
            }
            return CollectionsDetailsFragmentArgs(__collections)
        }
    }
}
