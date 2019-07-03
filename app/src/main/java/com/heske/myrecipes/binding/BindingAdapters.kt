package com.heske.myrecipes.binding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.heske.myrecipes.R
import com.heske.myrecipes.models.Category
import com.heske.myrecipes.ui.categorylist.CategoryListAdapter

/* Copyright (c) 2019 Jill Heske All rights reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
@BindingAdapter("categoryRecyclerListItems")
fun bindCategoryListRecyclerData(recyclerView: RecyclerView, data: List<Category>?) {
    val adapter = recyclerView.adapter as CategoryListAdapter
    adapter.submitList(data)
}

@BindingAdapter("categoryListItemImageUrl")
fun bindCategoryListItemImageUrl(imgView: ImageView, imageUrl: android.net.Uri?) {
    imageUrl?.let {
        Glide.with(imgView.context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .error(R.drawable.barbeque)
            )
            .into(imgView)
    }
}

@BindingAdapter("recipeListItemImageUrl")
fun bindRecipeListItemImageUrl(imgView: ImageView, imageUrl: String?) {
    val path
            = Uri.parse("android.resource://com.codingwithmitch.foodrecipes/drawable/$imageUrl")
    imageUrl?.let {
        Glide.with(imgView.context)
            .load(path)
            .apply(
                RequestOptions()
                    .error(R.drawable.barbeque)
            )
            .into(imgView)
    }
}