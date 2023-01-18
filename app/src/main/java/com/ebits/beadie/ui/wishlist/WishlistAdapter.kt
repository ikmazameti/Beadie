package com.ebits.beadie.ui.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.ebits.beadie.data.model.Product
import com.ebits.beadie.databinding.ItemFavBinding

class FavouriteAdapter(
    private val onCheckboxToggle: (Product) -> Unit, private val onRowClick: (Product) -> Unit
) : ListAdapter<Product, FavouriteAdapter.FavouriteViewHolder>(ProductDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavouriteViewHolder(
            ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onCheckboxToggle,
            onRowClick
        )


    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val product = getItem(position)
        if (product != null) holder.bind(product)
    }

    class FavouriteViewHolder(
        private val binding: ItemFavBinding,
        private val onCheckboxToggle: (Product) -> Unit,
        private val onRowClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {

            //TODO: Bind your views here
        }

    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.productId == newItem.productId

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}