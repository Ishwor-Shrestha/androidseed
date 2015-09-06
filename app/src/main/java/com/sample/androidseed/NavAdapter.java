package com.sample.androidseed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.androidseed.fonts.MaterialIconTextView;
import com.sample.androidseed.fonts.RobotoTextView;

/**
 * Created by User on 9/6/2015.
 */
public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    Context ct;
    String nav_titles[];
    String nav_icons[];

    public NavAdapter(Context context, String titles[], String icons[]) {
        ct = context;
        nav_titles = titles;
        nav_icons = icons;
    }


    @Override
    public NavAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_header, parent, false);
            return new ViewHolder(view, viewType);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_row, parent, false);
            return new ViewHolder(view, viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(NavAdapter.ViewHolder holder, int position) {
        if (holder.holderID == 1) {
            holder.tvNavTitle.setText(nav_titles[position - 1]);
            holder.tvNavIcon.setText(nav_icons[position - 1]);
        } else {
            //TODO do something
        }
    }

    @Override
    public int getItemCount() {
        return nav_titles.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        int holderID;

        MaterialIconTextView tvNavIcon;
        RobotoTextView tvNavTitle;

        public ViewHolder(View itemView, int ViewType) {
            super(itemView);

            if (ViewType == TYPE_HEADER) {
                holderID = 0;
            } else {
                tvNavIcon = (MaterialIconTextView) itemView.findViewById(R.id.tvNavIcon);
                tvNavTitle = (RobotoTextView) itemView.findViewById(R.id.tvNavTitle);
                holderID = 1;
            }
        }
    }
}
