package com.belluk.movapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belluk.movapps.R
import com.belluk.movapps.model.Plays
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlaysAdapter(private var data: List<Plays>,
                   private val listener: (Plays) -> Unit)
    : RecyclerView.Adapter<PlaysAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context
    private var detail:Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_item_play, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_kursi)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image_tiket)

        fun bindItem(data: Plays, listener: (Plays) -> Unit, context : Context, position : Int) {

            tvTitle.text = data.nama

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.circleCropTransform())
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}

