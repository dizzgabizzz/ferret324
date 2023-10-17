package com.example.ferret.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.ferret.Domain.FramesDomain;
import com.example.ferret.R;

import java.util.ArrayList;

public class FramesAdapter extends RecyclerView.Adapter<FramesAdapter.Viewholder> {


    ArrayList<FramesDomain> items;
    Context context;

    public FramesAdapter(ArrayList<FramesDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FramesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_frames,parent,false);
        context = parent.getContext();
        return new Viewholder(inflator) ;
    }

    @Override
    public void onBindViewHolder(@NonNull FramesAdapter.Viewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.subtitle.setText(items.get(position).getSubtitle());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicAddress(), "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends  RecyclerView.ViewHolder{
        TextView title, subtitle;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTxt);
            subtitle = itemView.findViewById(R.id.subtitleTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
