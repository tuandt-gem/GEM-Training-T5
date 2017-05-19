package com.luongapp.vanluong.androidbasic.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.adapter.RecyclerViewAdapter;
import com.luongapp.vanluong.androidbasic.model.obj.DemoRecy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanluong on 12/05/2017.
 */

public class FragmentFour extends BaseFragment {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private List<DemoRecy> demoRecies;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoRecies = new ArrayList<>();
        DemoRecy demoRecy = new DemoRecy("demo1", R.drawable.hinh1);
        DemoRecy demoRecy1 = new DemoRecy("demo2", R.drawable.hinh2);
        DemoRecy demoRecy2 = new DemoRecy("demo3", R.drawable.hinh3);
        DemoRecy demoRecy3 = new DemoRecy("demo4", R.drawable.hinh4);
        demoRecies.add(demoRecy);
        demoRecies.add(demoRecy1);
        demoRecies.add(demoRecy2);
        demoRecies.add(demoRecy3);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_four_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);

        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(demoRecies, getActivity());
        recyclerViewAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(recyclerViewAdapter);

        return rootView;
    }
}
