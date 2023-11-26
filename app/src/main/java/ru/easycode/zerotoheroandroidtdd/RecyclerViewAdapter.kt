package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import ru.easycode.zerotoheroandroidtdd.databinding.ListElementBinding

class RecyclerViewAdapter : Adapter<ViewHolder>() {

    private val itemsList = ArrayList<String>()

    fun add(source: String) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList("key", itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getStringArrayList("key")?.toList() ?: ArrayList())
        notifyItemRangeChanged(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListElementBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }
}

class ViewHolder(private val binding: ListElementBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(source: String) {
        binding.elementTextView.text = source
    }
}