package com.example.friebels.cookfriend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.friebels.cookfriend.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RecipeAdapterListView extends ArrayAdapter<Recipe> {

   List<Recipe> m_recipes;
   LayoutInflater m_inflater;

   public RecipeAdapterListView(Context context, List<Recipe> objects) {
      super(context, R.layout.receipes_item, objects);
      m_recipes = objects;
      m_inflater = LayoutInflater.from(context);
   }

   @NonNull
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {

      if (convertView == null) {
         convertView = m_inflater.inflate(R.layout.receipes_item, parent, false);
      }

      TextView tvName = (TextView) convertView.findViewById(R.id.recipeNameText);
      ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

      Recipe recipe = m_recipes.get(position);
      tvName.setText(recipe.getName());
      // imageView.setImageResource(R.drawable.apple_pie);
      InputStream inputStream = null;
      try {
         String filename = recipe.getImageFilename();
         inputStream = getContext().getAssets().open(filename);
         Drawable d = Drawable.createFromStream(inputStream, null);
         imageView.setImageDrawable(d);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      return convertView;
   }
}
