package com.example.friebels.cookfriend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.friebels.cookfriend.model.Recipe;
import com.example.friebels.cookfriend.sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecipesActivity extends AppCompatActivity
      implements NavigationView.OnNavigationItemSelectedListener {

   List<Recipe> recipes = SampleDataProvider.recipes;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_recipes);

      Toolbar toolbar = (Toolbar) findViewById(R.id.recipesToolbar);
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

      RecyclerView listView = (RecyclerView) findViewById(R.id.recipeRecyclerView);
      listView.setAdapter(adapter);
   }

   @Override
   public void onBackPressed() {
      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      if (drawer.isDrawerOpen(GravityCompat.START)) {
         drawer.closeDrawer(GravityCompat.START);
      } else {
         super.onBackPressed();
      }
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.recipes, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement

      return super.onOptionsItemSelected(item);
   }

   @SuppressWarnings("StatementWithEmptyBody")
   @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      // Handle navigation view item clicks here.
      int id = item.getItemId();

      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      drawer.closeDrawer(GravityCompat.START);
      return true;
   }
}
