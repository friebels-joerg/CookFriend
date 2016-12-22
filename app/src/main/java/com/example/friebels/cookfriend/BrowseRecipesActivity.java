package com.example.friebels.cookfriend;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.friebels.cookfriend.model.Recipe;
import com.example.friebels.cookfriend.sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BrowseRecipesActivity extends AppCompatActivity {

   RelativeLayout content = null;
   List<Recipe> recipes = SampleDataProvider.recipes;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_browse_recipes);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addRecipeButton);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Snackbar.make(view, "Add Recipe Button Pressed", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show();
         }
      });

      Collections.sort(recipes, new Comparator<Recipe>() {
         @Override
         public int compare(Recipe o1, Recipe o2) {
            return o1.getName().compareTo(o2.getName());
         }
      });

      RecipeAdapter adapter = new RecipeAdapter(this, recipes);

      RecyclerView listView = (RecyclerView) findViewById(R.id.recipesRecyclerView);
      listView.setAdapter(adapter);

      content = (RelativeLayout) findViewById(R.id.content_browse_recipes);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.browse_recipes, menu);
      return true;
   }
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      switch (id) {
         case R.id.action_filter:
            Snackbar.make(content, "You selected Filter", Snackbar.LENGTH_LONG)
                  .setAction("Action",null)
                  .show();
            return true;
      }

      //noinspection SimplifiableIfStatement
      return super.onOptionsItemSelected(item);
   }
}
