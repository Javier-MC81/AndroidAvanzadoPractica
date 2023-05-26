package com.jmoreno.androidavanzadopractica.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jmoreno.androidavanzadopractica.R
import com.jmoreno.androidavanzadopractica.ui.model.Superhero

class SuperheroAdapter(private val onClick: (String) -> (Unit)) : ListAdapter<Superhero, SuperheroAdapter.SuperheroViewHolder>(SuperheroDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    inner class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val superheroName = itemView.findViewById<TextView>(R.id.superhero_name)

        private lateinit var superhero: Superhero

        init {
            itemView.setOnClickListener {
                onClick(superhero.id)
            }
        }

        fun bind(superhero: Superhero) {
            this.superhero = superhero
            superheroName.text = superhero.name
        }
    }

    class SuperheroDiffCallback: DiffUtil.ItemCallback<Superhero>() {
        override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
            return oldItem == newItem
        }

    }
}
