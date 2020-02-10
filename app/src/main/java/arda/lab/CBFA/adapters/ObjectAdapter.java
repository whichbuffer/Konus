package arda.lab.CBFA.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import arda.lab.CBFA.BuildConfig;
import arda.lab.CBFA.R;
import arda.lab.CBFA.listeners.OnItemClickListener;
import arda.lab.CBFA.viewholders.ObjectViewHolder;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectViewHolder> {

    private String[][][] mDataset;
    private Context mContext;
    private int mActiveType;

    private OnItemClickListener mOnClickListener;

    public ObjectAdapter(int active_type, String[][][] dataset, Context context, OnItemClickListener onClickListener) {
        mDataset = dataset;
        mContext = context;
        mOnClickListener = onClickListener;
        mActiveType = active_type;
    }

    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_object, parent, false);

        return new ObjectViewHolder(v, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position) {
        holder.objectDescription.setTag(position);
        holder.objectDescription.setText(mDataset[mActiveType][position][1]);

        if (mDataset[mActiveType][position][0].startsWith("ben")) {
            holder.objectImage
                    .setImageDrawable(ContextCompat.getDrawable(mContext, mContext.getResources().getIdentifier(mDataset[mActiveType][position][0], "drawable", BuildConfig.APPLICATION_ID)));
        } else {
            Picasso.get()
                    .load(mContext.getResources().getIdentifier(mDataset[mActiveType][position][0], "drawable", BuildConfig.APPLICATION_ID))
                    .into(holder.objectImage);
        }

    }

    @Override
    public int getItemCount() {
        return mDataset[mActiveType].length;
    }
}
