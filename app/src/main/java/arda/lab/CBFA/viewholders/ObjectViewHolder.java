package arda.lab.CBFA.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import arda.lab.CBFA.R;
import arda.lab.CBFA.listeners.OnItemClickListener;

public class ObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView objectImage;
    public TextView objectDescription;

    public ObjectViewHolder(View itemView, final OnItemClickListener onClickListener) {
        super(itemView);

        objectImage = itemView.findViewById(R.id.object_image);
        objectDescription = itemView.findViewById(R.id.object_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(Integer.valueOf(objectDescription.getTag().toString()));
            }
        });

    }
}
