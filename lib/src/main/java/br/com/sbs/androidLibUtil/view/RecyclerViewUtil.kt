package br.com.sbs.androidLibUtil.view

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Valmir Júnior on 01/12/2017.
 */

object RecyclerViewUtil {

    /***
     * This method Return a [DividerItemDecoration] to be used for the recyclerView
     * @param recyclerView
     * @param manager
     * @return DividerItemDecoration
     */
    fun getItemDecorationDefault(recyclerView: RecyclerView,
                                 manager: LinearLayoutManager): DividerItemDecoration {
        return DividerItemDecoration(
                recyclerView.context, manager.orientation)
    }

    /**
     * SetUp the recyclerView with the [LinearLayoutManager] for default
     * @param recyclerView
     * @param adapter
     * @param context
     */
    fun setUpRecycler(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>,
                      context: Context) {
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(getItemDecorationDefault(recyclerView, layoutManager))
        recyclerView.adapter = adapter
    }


    /**
     * SetUp the recyclerView with the [LinearLayoutManager] for default
     * @param recyclerView
     * @param adapter
     * @param context
     */
    fun setUpRecyclerWithOutItemDecoration(recyclerView: RecyclerView,
                                           adapter: RecyclerView.Adapter<*>, context: Context) {
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    /**
     * This Method Update the User Iterface When the list is Empty.
     * Shows the textView and hide the recyclerView,
     * otherwise it's showed the recyclerView and hided the textView
     * @param list
     * @param recyclerView
     * @param textView
     */
    fun updateUiOfRecyclerView(list: List<*>?, recyclerView: RecyclerView, textView: TextView) {
        if (list == null || list.size == 0) {
            textView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            textView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}
