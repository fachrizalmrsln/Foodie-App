package com.id.zul.foodie.ui.listfoods

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.zul.foodie.R
import com.id.zul.foodie.model.Foods
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class FoodAdapter(private val context: Context, private val listener: (Foods) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private var food: MutableList<Foods> = mutableListOf()

    fun setData(data: List<Foods>) {
        food.clear()
        food.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivItem: ImageView = itemView.find(R.id.iv_item_foods)
        private val tvItem: TextView = itemView.find(R.id.tv_item_foods)

        fun bindItems(data: Foods, listener: (Foods) -> Unit) {
            tvItem.text = data.name
            itemView.context.let {
                Picasso
                    .get()
                    .load(data.image)
                    .placeholder(R.drawable.place_holder)
                    .into(ivItem)
            }
            itemView.setOnClickListener { listener(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return food.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        food[position].let { holder.bindItems(it, listener) }
    }

}