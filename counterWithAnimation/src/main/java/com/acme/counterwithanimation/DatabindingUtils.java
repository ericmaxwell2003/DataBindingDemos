package com.acme.counterwithanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DatabindingUtils {

    @BindingAdapter({"android:visibility"})
    public static void visibility(final View view, final int newVisibility) {

        final boolean makeVisible = newVisibility == View.VISIBLE;

        if (makeVisible) {
            view.setVisibility(newVisibility);
        }

        view.animate()
                .alpha(makeVisible ? 1.0f : 0.0f)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (!makeVisible) {
                            view.setVisibility(newVisibility);
                        }
                    }
                });
    }

    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImage(final ImageView view, final String url, final Drawable placeholder) {

        Picasso.with(view.getContext())
                .load(url)
                .placeholder(placeholder)
                .into(view);

    }
}
