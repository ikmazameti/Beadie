package com.ebits.beadie.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ebits.beadie.R
import com.ebits.beadie.data.model.Product
import com.ebits.beadie.databinding.ItemProductBinding

/**
 * Adapter class for [RecyclerView].
 */
class ProductAdapter(
    private val onCheckboxToggle: (Product) -> Unit, private val onRowClick: (Product) -> Unit
) : ListAdapter<Product, ProductAdapter.RosterViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RosterViewHolder(
        ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onCheckboxToggle,
        onRowClick
    )

    override fun onBindViewHolder(holder: RosterViewHolder, position: Int) {
        val currentProduct = getItem(position)
        if (currentProduct != null) holder.bind(currentProduct)
    }

    /**
     * This is method retrieves the current item
     *
     *
     * @param position
     * @return
     */
    fun getBabyItemAt(position: Int): Product {
        return getItem(position)
    }

    class RosterViewHolder(
        private val binding: ItemProductBinding,
        private val onCheckboxToggle: (Product) -> Unit,
        private val onRowClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {


        /**
         * This method binds the views to the data - [Product]
         */
        fun bind(product: Product) {
            binding.apply {
                root.setOnClickListener { onRowClick(product) }
                productName.text = product.productName
                productPrice.text = product.productPrice.toString()

                productImage.load(product.productPhotoUrl) {
                    crossfade(true)
                }
            }
        }
    }


}


/**
 * This class calculate the diff for the ListAdapters
 */
private object DiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(old: Product, new: Product): Boolean =
        old.productId == new.productId

    override fun areContentsTheSame(old: Product, new: Product): Boolean =
        old.productName == new.productName && old.productPrice == new.productPrice
}
