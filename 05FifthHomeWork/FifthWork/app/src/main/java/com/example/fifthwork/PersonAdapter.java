package com.example.fifthwork;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{

    private List<Person> mPersonList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View personView;
        ImageView personImage;
        TextView personName;
        TextView personNo;

        public ViewHolder(View view) {
            super(view);
            personView = view;
            personImage = (ImageView) view.findViewById(R.id.person_image);
            personName = (TextView) view.findViewById(R.id.person_name);
            personNo =(TextView) view.findViewById(R.id.person_no);
        }
    }

    public PersonAdapter(List<Person> personList) {
        mPersonList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.personView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Person person = mPersonList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.personImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Person person = mPersonList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = mPersonList.get(position);
        holder.personImage.setImageResource(person.getImageId());
        holder.personName.setText(person.getName());
        holder.personNo.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

}