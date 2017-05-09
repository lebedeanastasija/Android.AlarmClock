package com.alarmclock.anastasiya.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] F_name, D_name;
    int[] Img_res = {R.drawable.alarmclock,R.drawable.alarmclock, R.drawable.alarmclock, R.drawable.alarmclock};
    ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        F_name = getResources().getStringArray(R.array.film_names);
        D_name = getResources().getStringArray(R.array.director_names);
        int i = 0;
        for (String name: F_name) {
            DataProvider dataProvider = new DataProvider(Img_res[i], name, D_name[i]);
            arrayList.add(dataProvider);
            i++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void openAlarmClock(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, AlarmClockActivity.class);
        context.startActivity(intent);
    }
}
