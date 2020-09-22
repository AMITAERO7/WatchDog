package com.hackernight.watchdog.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hackernight.watchdog.R
import com.hackernight.watchdog.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter (val dogList :ArrayList<DogBreed>) : RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    fun updateList(newDogList:List<DogBreed>){
            dogList.clear()
            dogList.addAll(newDogList)
            notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog,parent,false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.textViewName.text = dogList[position].dogBreed
        holder.view.textViewLifeSpan.text = dogList[position].lifeSpan

        holder.view.setOnClickListener {
            var action = ListFragmentDirections.actionDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    class DogViewHolder(var view :View) : RecyclerView.ViewHolder(view) { }

    override fun getItemCount(): Int {
        return dogList.size
    }

}