package com.example.friebels.cookfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.friebels.cookfriend.model.Recipe;
import com.example.friebels.cookfriend.sample.SampleDataProvider;

public class RecipeDetailActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recipe_detail);

      String id = getIntent().getExtras().getString(RecipeAdapter.RECIPE_ID);
      Recipe recipe = SampleDataProvider.recipeMap.get(id);

      Toast .makeText(this, "Received item "+ recipe.getId(), Toast.LENGTH_SHORT)
            .show();

   }
}
