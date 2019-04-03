/*
 * Copyright (c) 2018 HugMotionTeam
 *
 */

package br.com.sbs.androidLibUtil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Valmir Júnior on 08/12/2018
 *
 * @param <T>  type off the object data
 *
 * @param <VH> An subtype of a GenericViewHolder
 */

abstract class AdapterGeneric<T,VH: AdapterGeneric.GenericViewHolder<T>>(
        private val layoutId: Int,
        private val typeVH: Class<VH>,
        var dataList: List<T>?,
        private val managerAdapter: AdapterGeneric.ManagerAdapter<T>? = null
): RecyclerView.Adapter<VH>() {


    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(layoutId, parent, false)
        return typeVH.getConstructor(View::class.java).newInstance(cellForRow)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val data = dataList!![position]
        holder.itemView.setOnClickListener { managerAdapter?.onClick(data) }
        holder.bind(position,data)
    }


    interface ManagerAdapter<T>{
        /***
         * This Fun it's responsible for delivery response on click to the, manager of this adapter
         */
        fun onClick(t:T)
    }

    abstract class GenericViewHolder <T> (itemView: View): RecyclerView.ViewHolder(itemView) {
        abstract fun bind(position:Int, t : T)
    }

}