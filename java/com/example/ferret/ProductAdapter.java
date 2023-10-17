package com.example.ferret;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements Filterable {


    public static final String TAG = "Product Adapter";

    private View.OnClickListener mOnClickListener;

    private View.OnLongClickListener mOnLongClickListener;

    private Context mContext;

    private List<Project> mProjectList;

    private List<Project> mProjectListFull;

    public ProductAdapter(Context mContext, List<Project> mProjectList) {
        this.mContext = mContext;
        this.mProjectList = mProjectList;
    }



    @Override
    public Filter getFilter() {
        return applyProjectFilter;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View mItemView = mLayoutInflater.inflate(R.layout.viewholder_frames , parent , false);
        return new ProductViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Project mProjectCurrent = mProjectList.get(position);
        holder.mTextViewItemProductName.setText(mProjectCurrent.getTitulo());
        holder.mImageViewProduct.setImageAlpha(Math.toIntExact(mProjectCurrent.getFoto_projeto()));
    }

    @Override
    public int getItemCount() {
        if(mProjectList != null){
            return mProjectList.size();
        } else {
            return 0;
        }

    }

    public void setProjectList(List<Project> mProjects){
        mProjectList = mProjects;
        mProjectListFull = new ArrayList<>(mProjects);
        notifyDataSetChanged();
    }

    public Project getProjectAt(int vPosition){
        return mProjectList.get(vPosition);
    }

    public void setOnItemClickListener(View.OnClickListener mItemClickListener){
        mOnClickListener = mItemClickListener;
    }

    public void setOnItemLongClickListener(View.OnClickListener mitemLongClickListener){
        mitemLongClickListener = mitemLongClickListener;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageViewProduct;
        private final TextView mTextViewItemProductName;





        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewProduct = itemView.findViewById(R.id.pic);
            mTextViewItemProductName = itemView.findViewById(R.id.titleTxt);


            itemView.setTag(this);

            itemView.setOnClickListener(mOnClickListener);


        }
    }

    private Filter applyProjectFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Project> mFilteredLIst = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                mFilteredLIst.addAll(mProjectListFull);
            } else {
                String mFilterPattern = charSequence.toString().toLowerCase().trim();
                for(Project mProject : mProjectListFull){
                    if(mProject.getTitulo().toLowerCase().contains(mFilterPattern)){
                        mFilteredLIst.add(mProject);
                    }

                }
            }
            FilterResults mFilterResults = new FilterResults();
            mFilterResults.values = mFilteredLIst;

            return mFilterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mProjectList.clear();
            mProjectList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}