package com.example.friebels.cookfriend;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friebels.cookfriend.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

   private List<Recipe> m_items;
   private Context m_context;

   public RecipeAdapter(Context context, List<Recipe> items) {
      this.m_context = context;
      this.m_items = items;
   }

   @Override
   public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(m_context);
      View itemView = inflater.inflate(R.layout.receipes_rvitem, parent, false);
      ViewHolder viewHolder = new ViewHolder(itemView);
      return viewHolder;
   }

   @Override
   public void onBindViewHolder(RecipeAdapter.ViewHolder holder, int position) {
      final Recipe recipe = m_items.get(position);

      try {
         holder.recipeNameText.setText(recipe.getName());
         String imageFile = recipe.getImageFilename();
         InputStream inputStream = m_context.getAssets().open(imageFile);
         Drawable d = Drawable.createFromStream(inputStream, null);
         holder.imageView.setImageDrawable(d);


      } catch (IOException e) {
         e.printStackTrace();
      }

      holder.m_view.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast .makeText(m_context, "You selected " + recipe.getName(), Toast.LENGTH_SHORT)
                  .show();
         }
      });

      holder.m_view.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
            Toast .makeText(m_context, "You long clicked " + recipe.getName(), Toast.LENGTH_SHORT)
                  .show();
            return false;
         }
      });
   }

   @Override
   public int getItemCount() {
      return m_items.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {

      public TextView recipeNameText;
      public ImageView imageView;

      public View m_view;
      public ViewHolder(View recipeView) {
         super(recipeView);
         recipeNameText = (TextView) recipeView.findViewById(R.id.recipeNameText);
         imageView = (ImageView) recipeView.findViewById(R.id.imageView);
         m_view= recipeView;
      }
   }
}