package com.example.ivr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class  MenuFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Toast.makeText(getContext(),"onCreate",Toast.LENGTH_LONG).show();
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        Bundle bundle = getArguments();
        String names [] = bundle.getStringArray("StringKey");
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragmentRecycler);
        MenuAdapter menuAdapter= new MenuAdapter(getActivity(),names);
        menuAdapter.setFragmentActionListener((MainActivity)getActivity());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menuAdapter);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Tal Kalderon");

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Toast.makeText(getContext(),"onAcitity",Toast.LENGTH_LONG).show();
    }


}
