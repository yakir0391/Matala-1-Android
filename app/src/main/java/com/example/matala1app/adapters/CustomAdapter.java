package com.example.matala1app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matala1app.R;
import com.example.matala1app.models.DataModel;

import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataModels;
    private  ArrayList<DataModel> dataModelsFull;
    public CustomAdapter(ArrayList<DataModel> dataModels){
        this.dataModels = dataModels;
        this.dataModelsFull = new ArrayList<>(dataModels);
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewDescriptin = holder.textViewDescription;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataModels.get(position).getName());
        textViewDescriptin.setText(dataModels.get(position).getDescription());
        imageView.setImageResource(dataModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
    public void filter(String text){
        dataModels.clear();

        if(text.isEmpty()){
            dataModels.addAll(dataModelsFull);
        }
        else{
            text = text.toLowerCase();
            for (DataModel dataModel : dataModelsFull) {
                if (dataModel.getName().toLowerCase().contains(text)){
                    dataModels.add(dataModel);
                }

            }
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.Name);
            textViewDescription = itemView.findViewById(R.id.Description);
        }
    }
}
