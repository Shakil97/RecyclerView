package com.example.recyclerview;

import android.app.Person;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{

    private ArrayList<person> people;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }



    public PersonAdapter(Context context,ArrayList<person> list)
    {
        people=list;
        activity=(ItemClicked) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView ivpre;
        TextView ivname;
        TextView ivsurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivname=itemView.findViewById(R.id.ivname);
            ivsurname=itemView.findViewById(R.id.ivsurname);
            ivpre=itemView.findViewById(R.id.ivpre);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(people.indexOf((person)v.getTag()));

                }
            });
        }
    }



    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));
        viewHolder.ivname.setText(people.get(i).getName());
        viewHolder.ivsurname.setText(people.get(i).getSurname());

        if (people.get(i).setPreferance().equals("bus"))
        {
            viewHolder.ivpre.setImageResource(R.drawable.bus);
        }
        else
        {
            viewHolder.ivpre.setImageResource(R.drawable.plane);
        }


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
