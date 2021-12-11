package id.nuryono.testapi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.nuryono.testapi.databinding.ListItemBinding
import id.nuryono.testapi.model.Heroes

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var myList = emptyList<Heroes>()

    inner class ViewHolder(private var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(heroes : Heroes) {
            binding.tvName.text = heroes.name
            binding.tvBirthYear.text = heroes.birthYear
            binding.tvDeathYear.text = heroes.deathYear.toString()
            binding.tvDescription.text = heroes.description
            binding.tvAscensionYear.text = heroes.ascensionYear.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newlist: List<Heroes>) {
        myList = newlist
        notifyDataSetChanged()
    }
}