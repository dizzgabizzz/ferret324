package com.example.ferret;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProductViewHolder> implements Filterable {


    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private Context mContext;

    private List<Project> mProjectList;

    private List<Project> ProjectListFull;



    public ProjectAdapter
    (Context context, List<Project> ProjectList) { //nv2
        mContext = context;
        mProjectList = ProjectList;


    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageViewProduct;
        private final TextView mTextViewItemProductDescription;
        private final TextView mTextViewItemProductPrice;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageViewProduct = itemView.findViewById(R.id.pic);
            mTextViewItemProductDescription = itemView.findViewById(R.id.titleTxt);
            mTextViewItemProductPrice = itemView.findViewById(R.id.subtitleTxt);

            itemView.setTag(this);

            itemView.setOnClickListener(mOnClickListener);
        }
    }

    @NonNull
    @Override  // esse método carrega um item da lista
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext); //nv
        View mItemView = mLayoutInflater.inflate(R.layout.viewholder_frames, parent, false);
        return new ProductViewHolder(mItemView);
    }



    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int vPosition) {
        Project mProjectCurrent = mProjectList.get(vPosition);
        holder.mTextViewItemProductDescription.setText(mProjectCurrent.getTitulo());
        holder.mTextViewItemProductPrice.setText(String.valueOf(mProjectCurrent.getDescricao()));



        //mProductViewHolder.mImageViewProduct.setImageDrawable(mContext.getResources().getDrawable(mProductCurrent.getImage()));

      //  Glide.with().load().into();

    }

    @Override
    public int getItemCount() {
        if(mProjectList != null){
            return  mProjectList.size();
        } else {
            return 0;
        }
    }

    public void setProductList(List<Project> mProducts){
        mProjectList = mProducts;
        ProjectListFull = new ArrayList<>(mProducts);
        notifyDataSetChanged();
    }

    public Project getProductAt(int vPosition){
        return mProjectList.get(vPosition);
    }

    public void setOnItemClickListener(View.OnClickListener mItemClickListener){
        mOnClickListener = mItemClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener mItemLongClickListener){
        mOnLongClickListener = mItemLongClickListener;
    }

    private Filter applyProductFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Project> mFilteredList = new ArrayList<>();
            if(charSequence == null  ||  charSequence.length() == 0 ) {
                mFilteredList.addAll(ProjectListFull);
            } else {
                String mFilterPattern = charSequence.toString().toLowerCase().trim();
                for(Project mProduct : ProjectListFull ) {
                    if(mProduct.getTitulo().toLowerCase().contains(mFilterPattern)){
                        mFilteredList.add(mProduct);
                    }
                }
            }
            FilterResults mFilterResults = new FilterResults();
            mFilterResults.values = mFilteredList;
            return mFilterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mProjectList.clear();
            mProjectList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter(){
        return applyProductFilter;
    }

}

