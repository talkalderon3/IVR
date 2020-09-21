package com.example.ivr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private String[] names;
    private Context context;
    FragmentActionListener fragmentActionListener;
    public MenuAdapter(Context context, String[] names) {
        this.context = context;
        this.names = names;
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.menu_items,parent,false);
        final MenuViewHolder menuViewHolder=new MenuViewHolder(view);
        return  menuViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
            final String name = names[position];
            holder.textView.setText(name);
            if (holder.textView.getText().equals("next")) {
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String [] strings = {"tal","kalderon","next"};
                        Bundle bundle = new Bundle();
                        bundle.putStringArray("StringKey",strings);
                        fragmentActionListener.onActionPerformed(bundle);
                    }
                });
        }
    }

    @Override
    public int getItemCount() {
        return  names.length;
    }

    public void  setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }
    class MenuViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

    }

}
