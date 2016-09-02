package com.example.givemepass.bubbleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DisplayMetrics dm;
    private MyView bubbleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        bubbleView = new MyView(this,dm.widthPixels,dm.heightPixels);
        setContentView(bubbleView);
        registerForContextMenu(bubbleView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "UP");
        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "DOWN");
        menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "LEFT");
        menu.add(Menu.NONE, Menu.FIRST+3, Menu.NONE, "RIGHT");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu.FIRST:
                bubbleView.setDirection(MyView.UP);
                break;
            case Menu.FIRST+1:
                bubbleView.setDirection(MyView.DOWN);
                break;
            case Menu.FIRST+2:
                bubbleView.setDirection(MyView.LEFT);
                break;
            case Menu.FIRST+3:
                bubbleView.setDirection(MyView.RIGHT);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
