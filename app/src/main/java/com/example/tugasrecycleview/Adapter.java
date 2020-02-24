package com.example.tugasrecycleview;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {
    private ArrayList<PahlawanModel> modelPahlawans;
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        Glide.with(context).load(getModelPahlawans().get(position).getHeroImages()).into(holder.imagePahlawan);
        holder.tvNama.setText(getModelPahlawans().get(position).getHeroNames());
//        holder.tvDetail.setText(getModelPahlawans().get(position).getHeroDetails());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Detail.class);
                i.putExtra("nama",getModelPahlawans().get(position).getHeroNames());
                i.putExtra("detail",getModelPahlawans().get(position).getHeroDetails());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getModelPahlawans().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePahlawan;
        private TextView tvNama, tvDetail;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePahlawan = itemView.findViewById(R.id.image);
            tvNama = itemView.findViewById(R.id.name);
//            tvDetail = itemView.findViewById(R.id.deskrip);
            linearLayout = itemView.findViewById(R.id.lineralayout);
        }
    }

    public ArrayList<PahlawanModel> getModelPahlawans() {
        return modelPahlawans;
    }

    public void setModelPahlawans(ArrayList<PahlawanModel> modelPahlawans) {
        this.modelPahlawans = modelPahlawans;
    }
}
