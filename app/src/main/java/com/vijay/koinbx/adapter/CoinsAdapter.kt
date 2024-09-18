package com.vijay.koinbx.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vijay.koinbx.R
import com.vijay.koinbx.pojo.Coin

class CoinsAdapter(context: Context) : RecyclerView.Adapter<CoinsAdapter.UserViewHolder>() {

    private var coins: List<Coin> = emptyList()
    var context:Context
    init {
        this.context = context
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layoutcolor: RelativeLayout = itemView.findViewById(R.id.colorchange)
        val arrow: ImageView = itemView.findViewById(R.id.arrow)
        val from: TextView = itemView.findViewById(R.id.from)
        val to: TextView = itemView.findViewById(R.id.to)
        val image: ImageView = itemView.findViewById(R.id.img)
        val fromsmall: TextView = itemView.findViewById(R.id.fromsmall)
        val pricechange: TextView = itemView.findViewById(R.id.pricechange)
        val lastprice: TextView = itemView.findViewById(R.id.lastprice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val Coins = coins[position]
        holder.from.text = Coins.pair_from
        holder.to.text = Coins.pair_to
        holder.fromsmall.text = Coins.pair_from
        holder.lastprice.text = Coins.last_price
        if (Coins.price_change.startsWith("-")){
            holder.layoutcolor.setBackgroundResource(R.drawable.rect)
            holder.arrow.setBackgroundResource(R.drawable.baseline_arrow_downward_24)
        }else{
            holder.layoutcolor.setBackgroundResource(R.drawable.rectgreen)
            holder.arrow.setBackgroundResource(R.drawable.baseline_arrow_upward_24)
        }
        holder.pricechange.text = Coins.price_change.toString().addpercentage()
        Glide.with(context).load(Coins.pair_image).apply(RequestOptions.circleCropTransform()).into(holder.image)

    }

    override fun getItemCount(): Int = coins.size

    // Update the list of coins
    fun submitList(newcoins: List<Coin>) {
        coins = newcoins
        notifyDataSetChanged()
    }
}

fun String.addpercentage() = "$this %"
