package br.com.sbs.android_lib_util.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mvdkpj02r on 12/1/17.
 */

public class RecyclerViewUtil {

    /***
     * This method Return a {@link DividerItemDecoration} to be used for the recyclerView
     * @param recyclerView
     * @param manager
     * @return DividerItemDecoration
     */
    public static DividerItemDecoration getItemDecorationDefault(RecyclerView recyclerView,
                                                                 LinearLayoutManager manager){
        return new DividerItemDecoration(
                recyclerView.getContext(), manager.getOrientation());
    }

    /**
     * SetUp the recyclerView with the {@link LinearLayoutManager} for default
     * @param recyclerView
     * @param adapter
     * @param context
     */
    public static void setUpRecycler(RecyclerView recyclerView, RecyclerView.Adapter adapter,Context context){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(getItemDecorationDefault(recyclerView,layoutManager));
        recyclerView.setAdapter(adapter);
    }


    /**
     * SetUp the recyclerView with the {@link LinearLayoutManager} for default
     * @param recyclerView
     * @param adapter
     * @param context
     */
    public static void setUpRecyclerWithOutItemDecoration(RecyclerView recyclerView, RecyclerView.Adapter adapter,Context context){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * This Method Update the User Iterface When the list is Empty.
     * Shows the textView and hide the recyclerView,
     * otherwise it's showed the recyclerView and hided the textView
     * @param list
     * @param recyclerView
     * @param textView
     */
    public static void updateUiOfRecyclerView(List list, @NonNull RecyclerView recyclerView, @NonNull TextView textView){
        if(list == null || list.size() ==0){
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            textView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}
