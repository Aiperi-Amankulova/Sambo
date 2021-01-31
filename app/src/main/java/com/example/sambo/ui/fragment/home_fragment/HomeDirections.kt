import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sambo.R
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.data.model.tip_the_day.TipOfTheDayModal
import java.io.Serializable

class HomeDirections private constructor() {
    private data class ActionHomeFragmentToNewsDetailsFragment(
        val details: RowsItem? = null
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_homeFragment_to_newsDetailsFragment

        @Suppress("CAST_NEVER_SUCCEEDS")
        override fun getArguments(): Bundle {
            val result = Bundle()
            if (Parcelable::class.java.isAssignableFrom(RowsItem::class.java)) {
                 result.putParcelable("details", this.details as Parcelable?)
            } else if (Serializable::class.java.isAssignableFrom(RowsItem::class.java)) {
                result.putSerializable("details", this.details as Serializable?)
            }
            return result
        }
    }

    private data class ActionHomeFragmentToCollectionsDetailsFragment(
        val collections: com.example.sambo.data.model.home_collections.RowsItem? = null
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_homeFragment_to_collectionsDetailsFragment

        @Suppress("CAST_NEVER_SUCCEEDS")
        override fun getArguments(): Bundle {
            val result = Bundle()
            if
                    (Parcelable::class.java.isAssignableFrom(com.example.sambo.data.model.home_collections.RowsItem::class.java)) {
                result.putParcelable("collections", this.collections as Parcelable?)
            } else if
                           (Serializable::class.java.isAssignableFrom(com.example.sambo.data.model.home_collections.RowsItem::class.java)) {
                result.putSerializable("collections", this.collections as Serializable?)
            }
            return result
        }
    }

    private data class ActionHomeFragmentToAdviceDetailsFragment(
        val advice: TipOfTheDayModal? = null
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_homeFragment_to_adviceDetailsFragment

        @Suppress("CAST_NEVER_SUCCEEDS")
        override fun getArguments(): Bundle {
            val result = Bundle()
            if (Parcelable::class.java.isAssignableFrom(TipOfTheDayModal::class.java)) {
                result.putParcelable("advice", this.advice as Parcelable?)
            } else if (Serializable::class.java.isAssignableFrom(TipOfTheDayModal::class.java)) {
                result.putSerializable("advice", this.advice as Serializable?)
            }
            return result
        }
    }

    companion object {
        fun actionHomeFragmentToNewsDetailsFragment(details: RowsItem? = null): NavDirections =
            ActionHomeFragmentToNewsDetailsFragment(details)

        fun actionHomeFragmentToCollectionsDetailsFragment(collections: com.example.sambo.data.model.home_collections.RowsItem?
                                                           = null): NavDirections = ActionHomeFragmentToCollectionsDetailsFragment(collections)

        fun actionHomeFragmentToAdviceDetailsFragment(advice: TipOfTheDayModal? = null): NavDirections =
            ActionHomeFragmentToAdviceDetailsFragment(advice)
    }
}
