package com.example.androidmvvmlogin.ui.carousel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvvmlogin.R
import com.example.androidmvvmlogin.ui.util.formatTrackTime


class ModelAdapter(
    private val context: Context,
    private val list: List<ModelCarousel>
) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val modelData = list[position]
       // holder.img.load(modelData.image)
        holder.name.text = modelData.trackName
        holder.genre.text = modelData.primaryGenreName
        holder.price.text = modelData.trackPrice.toString()
      //  holder.duration.text = formatTrackTime(modelData.trackTimeMillis)
    }

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgModel)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val genre: TextView = itemView.findViewById(R.id.tvGenre)
        val price: TextView = itemView.findViewById(R.id.tvPrice)
        val duration: TextView = itemView.findViewById(R.id.tvDuration)
    }
}