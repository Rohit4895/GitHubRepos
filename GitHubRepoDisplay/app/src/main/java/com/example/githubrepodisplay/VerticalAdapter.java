package com.example.githubrepodisplay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {
    Context context;
    List<Items> usersLists;

    public VerticalAdapter(Context context, List<Items> usersLists) {
        this.context = context;
        this.usersLists = usersLists;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vertical_recycler_view,viewGroup,false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VerticalViewHolder verticalViewHolder, final int position) {

        verticalViewHolder.mainText.setText(usersLists.get(position).getLogin());
       verticalViewHolder.subText.setText(usersLists.get(position).getId()+"");
        verticalViewHolder.price.setText(usersLists.get(position).getType());

        Glide.with(context)
                .load(usersLists.get(position).getAvatarUrl())
                .centerCrop()
                .placeholder(R.drawable.cart)
                .into(verticalViewHolder.imageView);

        verticalViewHolder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof IMethodCaller){
                    ((IMethodCaller)context).onClickNotify();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersLists.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        TextView mainText, subText, price, notification;
        RatingBar ratingBar;
        ToggleButton favourite;
        ImageView imageView;
        Button addToCart;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);

            mainText = itemView.findViewById(R.id.mainText);
        //    notification = itemView.findViewById(R.id.notification);
            subText = itemView.findViewById(R.id.subText);
            price = itemView.findViewById(R.id.price);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            favourite = itemView.findViewById(R.id.favourite);
            imageView = itemView.findViewById(R.id.imageView);
            addToCart = itemView.findViewById(R.id.addToCart);
        }
    }

    public interface IMethodCaller{
        void onClickNotify();
    }
}
