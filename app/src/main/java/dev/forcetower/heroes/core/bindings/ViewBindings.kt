package dev.forcetower.heroes.core.bindings

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dev.forcetower.heroes.core.extensions.doOnApplyWindowInsets

@BindingAdapter(
    "paddingStartSystemWindowInsets",
    "paddingTopSystemWindowInsets",
    "paddingEndSystemWindowInsets",
    "paddingBottomSystemWindowInsets",
    requireAll = false
)
fun applySystemWindows(
    view: View,
    applyLeft: Boolean,
    applyTop: Boolean,
    applyRight: Boolean,
    applyBottom: Boolean
) {
    view.doOnApplyWindowInsets { _, insets, padding ->
        val left = if (applyLeft) insets.systemWindowInsetLeft else 0
        val top = if (applyTop) insets.systemWindowInsetTop else 0
        val right = if (applyRight) insets.systemWindowInsetRight else 0
        val bottom = if (applyBottom) insets.systemWindowInsetBottom else 0

        view.setPadding(
            padding.left + left,
            padding.top + top,
            padding.right + right,
            padding.bottom + bottom
        )
    }
}

@BindingAdapter("goneIf")
fun goneIf(view: View, gone: Boolean) {
    view.visibility = if (gone) View.GONE else View.VISIBLE
}

@BindingAdapter("goneUnless")
fun goneUnless(view: View, condition: Boolean) {
    view.visibility = if (condition) View.VISIBLE else View.GONE
}

@BindingAdapter("swipeRefreshColors")
fun setSwipeRefreshColors(swipeRefreshLayout: SwipeRefreshLayout, colorResIds: IntArray) {
    swipeRefreshLayout.setColorSchemeColors(*colorResIds)
}

@BindingAdapter("refreshing")
fun swipeRefreshing(refreshLayout: SwipeRefreshLayout, refreshing: Boolean) {
    refreshLayout.isRefreshing = refreshing
}

@BindingAdapter("onSwipeRefresh")
fun onSwipeRefresh(view: SwipeRefreshLayout, function: SwipeRefreshLayout.OnRefreshListener) {
    view.setOnRefreshListener(function)
}

@BindingAdapter("swipeEnabled")
fun swipeEnabled(view: SwipeRefreshLayout, enabled: Boolean) {
    view.isEnabled = enabled
}
