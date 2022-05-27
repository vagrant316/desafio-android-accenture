package com.example.accenture.ui.repository.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accenture.core.BaseViewHolder
import com.example.accenture.databinding.RepositoryListItemBinding
import com.example.accenture.presentation.repository.model.RepositoryItem

class RepositoryAdapter(private val repositoryList: List<RepositoryItem>)
    : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            RepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is RepositoryViewHolder -> holder.bind(repositoryList[position])
        }
    }

    override fun getItemCount(): Int {
        return repositoryList.count()
    }


    private inner class RepositoryViewHolder(
        val binding: RepositoryListItemBinding,
        val context: Context
    ) : BaseViewHolder<RepositoryItem>(binding.root) {
        override fun bind(item: RepositoryItem) {
           binding.apply {
               nameTextview.text = item.name
               descriptionTextView.text = item.description
               binding.autorTextView.text = item.owner.login
               binding.forkTextView.text = item.forkCount.toString()
               binding.starTextView.text = item.stargazerCount.toString()

           }
        }
    }
}