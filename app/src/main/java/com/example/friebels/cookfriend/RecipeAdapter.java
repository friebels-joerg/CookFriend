package com.example.friebels.cookfriend;
import android.content.Context;
import android.content.Intent;
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

   public static final String RECIPE_ID = "recipeId";
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
         holder.m_recipeNameText.setText(recipe.getName());
         String imageFile = recipe.getImageFilename();
         InputStream inputStream = m_context.getAssets().open(imageFile);
         Drawable d = Drawable.createFromStream(inputStream, null);
         holder.m_imageView.setImageDrawable(d);


      } catch (IOException e) {
         e.printStackTrace();
      }

      holder.m_view.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast .makeText(m_context, "You selected " + recipe.getName(), Toast.LENGTH_SHORT)
                  .show();
            String id = recipe.getId();
            Intent intent = new Intent(m_context, RecipeDetailActivity.class);
            intent.putExtra(RECIPE_ID, id);
            m_context.startActivity(intent);
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

      public TextView m_recipeNameText;
      public ImageView m_imageView;

      public View m_view;
      public ViewHolder(View recipeView) {
         super(recipeView);
         m_recipeNameText = (TextView) recipeView.findViewById(R.id.recipeNameText);
         m_imageView = (ImageView) recipeView.findViewById(R.id.imageView);
         m_view= recipeView;
      }
   }
}