package com.rk.riggle_sales.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.rk.riggle_sales.R

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["simpleRecourse"])
    fun setStepGroupIcon(imageView: ImageView, simpleResourse: Int) {
        if (simpleResourse != -1) {
            imageView.setImageResource(simpleResourse)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["local_images"])
    fun setLocalImages(imageView: ImageView, image_url: String?) {
        image_url?.let {
            Glide.with(imageView.context)
                .load(image_url)
                /*.override(imageView.width, imageView.height)*/
                .placeholder(R.drawable.ic_profile_place_holder)
                .into(imageView)
        }
    }


    @JvmStatic
    @BindingAdapter(value = ["logo_images"])
    fun setLogoImages(imageView: ImageView, image_url: String?) {
        image_url?.let {
            Glide.with(imageView.context)
                .load(it)
                /*.override(imageView.width, imageView.height)*/
                .placeholder(R.drawable.ic_pizza_icon)
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["update_status_top"])
    fun updateStatusTop(view: View, status: String?) {
        var buttonDrawable: Drawable? = view.getBackground()
        buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
        if (status != null) {
            when (status) {
                "Accepted" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context, R.color.color_442B7EOne)
                    )
                }
                "Arrived" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_5DC4CC)
                    )
                }
                "OrderPicked" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_D9AE56)
                    )
                }
                "DeliveryStarted" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_5CAC7D)
                    )
                }
                "Completed" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_done_delivery)
                    )
                }
            }
            view.setBackground(buttonDrawable)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["update_status_bottom"])
    fun updateStatusBottom(view: View, status: String?) {
        var buttonDrawable: Drawable? = view.getBackground()
        buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
        if (status != null) {
            when (status) {
                "Accepted" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_3E305FOne)
                    )
                }
                "Arrived" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_4DA8AF)
                    )
                }
                "OrderPicked" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_CF9723)
                    )
                }
                "DeliveryStarted" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_4E996D)
                    )
                }
                "Completed" -> {
                    DrawableCompat.setTint(
                        buttonDrawable,
                        ContextCompat.getColor(view.context,R.color.color_done_delivery)
                    )
                }
            }
            view.setBackground(buttonDrawable)
        }
    }


    @JvmStatic
    @BindingAdapter(value = ["update_status_color"])
    fun updateStatusColor(textView: TextView, status: String?) {
        if (status != null) {
            when (status) {
                "Accepted" -> {
                    textView.text = "Ahead to restaurant"
                    textView.setTextColor(ContextCompat.getColor(textView.context,R.color.color_442B7EOne))
                }
                "Arrived" -> {
                    textView.text = "Arrived at the restaurant"
                    textView.setTextColor(ContextCompat.getColor(textView.context,R.color.color_4DA8AF))
                }
                "OrderPicked" -> {
                    textView.text = "Order Picked"
                    textView.setTextColor(ContextCompat.getColor(textView.context,R.color.color_CF9723))
                }
                "DeliveryStarted" -> {
                    textView.text = "Delivery Started"
                    textView.setTextColor(ContextCompat.getColor(textView.context,R.color.color_4E996D))
                }
                "Completed" -> {
                    textView.text = "Completed"
                    textView.setTextColor(ContextCompat.getColor(textView.context,R.color.color_done_delivery))
                }
            }
        }
    }

}