package com.example.friebels.cookfriend.sample;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friebels.cookfriend.R;
import com.example.friebels.cookfriend.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

   private List<Recipe> m_items;
   private Context m_context;

   public DataItemAdapter(Context context, List<Recipe> items) {
      this.m_context = context;
      this.m_items = items;
   }

   @Override
   public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(m_context);
      View itemView = inflater.inflate(R.layout.receipes_item, parent, false);
      ViewHolder viewHolder = new ViewHolder(itemView);
      return viewHolder;
   }

   @Override
   public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
      Recipe item = m_items.get(position);

      try {
         holder.tvName.setText(item.getName());
         String imageFile = item.getImageFilename();
         InputStream inputStream = m_context.getAssets().open(imageFile);
         Drawable d = Drawable.createFromStream(inputStream, null);
         holder.imageView.setImageDrawable(d);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public int getItemCount() {
      return m_items.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {

      public TextView tvName;
      public ImageView imageView;
      public ViewHolder(View itemView) {
         super(itemView);

         tvName = (TextView) itemView.findViewById(R.id.recipeNameText);
         imageView = (ImageView) itemView.findViewById(R.id.imageView);
      }
   }
}