package com.example.mjie_.android_qizhonga.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mjie_.android_qizhonga.R;
import com.example.mjie_.android_qizhonga.bean.MBean;

import java.util.ArrayList;

public class RecycAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MBean.ResultBean> list;

    public RecycAdapter(Context context, ArrayList<MBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
            holder = new Item1ViewHolder(inflate);
        }
        if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item2, parent, false);
            holder = new Item2ViewHolder(inflate);
        }
        if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item3, parent, false);
            holder = new Item3ViewHolder(inflate);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            Item1ViewHolder holder1 = (Item1ViewHolder) holder;
            holder1.item1_con.setText(list.get(position).getText());
            holder1.item1_title.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getHeader()).into(holder1.item1_img);
        }
        if (itemViewType == 2) {
            Item2ViewHolder holder2 = (Item2ViewHolder) holder;
            holder2.item2_con.setText(list.get(position).getText());
            holder2.item2_title.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getHeader()).into(holder2.item2_img1);
            Glide.with(context).load(list.get(position).getHeader()).into(holder2.item2_img2);
        }
        if (itemViewType == 3) {
            Item3ViewHolder holder3 = (Item3ViewHolder) holder;
            holder3.item3_con.setText(list.get(position).getText());
            holder3.item3_title.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getHeader()).into(holder3.item3_img1);
            Glide.with(context).load(list.get(position).getHeader()).into(holder3.item3_img2);
            Glide.with(context).load(list.get(position).getHeader()).into(holder3.item3_img3);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myonc != null) {
                    myonc.myonc(position);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 1;
        } else if (position % 3 == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Item1ViewHolder extends RecyclerView.ViewHolder {


        private ImageView item1_img;
        private TextView item1_title;
        private TextView item1_con;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            item1_con = itemView.findViewById(R.id.item1_con);
            item1_title = itemView.findViewById(R.id.item1_title);
            item1_img = itemView.findViewById(R.id.item1_img);

        }
    }

    class Item2ViewHolder extends RecyclerView.ViewHolder {


        private ImageView item2_img2;
        private ImageView item2_img1;
        private TextView item2_title;
        private TextView item2_con;

        public Item2ViewHolder(View itemView) {
            super(itemView);
            item2_con = itemView.findViewById(R.id.item2_con);
            item2_title = itemView.findViewById(R.id.item2_title);
            item2_img1 = itemView.findViewById(R.id.item2_img1);
            item2_img2 = itemView.findViewById(R.id.item2_img2);

        }
    }

    class Item3ViewHolder extends RecyclerView.ViewHolder {


        private TextView item3_con;
        private TextView item3_title;
        private ImageView item3_img1;
        private ImageView item3_img2;
        private ImageView item3_img3;

        public Item3ViewHolder(View itemView) {
            super(itemView);
            item3_con = itemView.findViewById(R.id.item3_con);
            item3_title = itemView.findViewById(R.id.item3_title);
            item3_img1 = itemView.findViewById(R.id.item3_img1);
            item3_img2 = itemView.findViewById(R.id.item3_img2);
            item3_img3 = itemView.findViewById(R.id.item3_img3);

        }
    }

    public interface Myonc {
        void myonc(int post);
    }

    private Myonc myonc;

    public void setMyonc(Myonc myonc) {
        this.myonc = myonc;
    }
}
