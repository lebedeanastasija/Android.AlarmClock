package com.alarmclock.anastasiya.alarmclock;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycleViewHolder> {
    private ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    public RecyclerAdapter(ArrayList<DataProvider> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(view);
        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position){
        DataProvider dataProvider = arrayList.get(position);
        holder.imageView.setImageResource(dataProvider.getImg_res());
        holder.f_name.setText(dataProvider.getF_name());
        holder.d_name.setText(dataProvider.getD_name());
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView f_name, d_name;
        private final Context context;

        public RecycleViewHolder(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.img);
            f_name = (TextView)view.findViewById(R.id.f_name);
            d_name = (TextView)view.findViewById(R.id.d_name);
            context = view.getContext();
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Intent intent;
            intent =  new Intent(context, AlarmClockActivity.class);
            context.startActivity(intent);
        }
    }
}
