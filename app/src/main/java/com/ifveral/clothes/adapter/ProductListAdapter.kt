package com.ifveral.clothes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ifveral.clothes.R
import com.ifveral.clothes.databinding.ProductListItemBinding
import com.ifveral.clothes.model.ProductListItem
import com.ifveral.clothes.ui.catalogue.list.HomeFragmentDirections
import com.squareup.picasso.Picasso


class ProductListAdapter :
    ListAdapter<ProductListItem, ProductListAdapter.ViewHolder>(ResultDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = getItem(position)
        with(result) {
            Picasso.get().load(this.image).placeholder(R.drawable.ic_home_black_24dp)
                .into(holder.productImg)
            holder.productTitle.text = this.name
            holder.productPrice.text = "$${this.price}"
            holder.container.setOnClickListener {
                /*it.findNavController().navigate(
                    HomeFragmentDirections.actionNavigationCatalogueToProductDetailFragment(
                        this.productId
                    )
                )*/
            }
        }
    }


    inner class ViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val container = binding.container
        val productImg = binding.productImg
        val productTitle = binding.productTitle
        val productPrice = binding.productPrice
    }
}

private class ResultDiffCallBack : DiffUtil.ItemCallback<ProductListItem>() {
    override fun areItemsTheSame(
        oldItem: ProductListItem,
        newItem: ProductListItem
    ): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(
        oldItem: ProductListItem,
        newItem: ProductListItem
    ): Boolean {
        return oldItem == newItem
    }
}