package com.alainperez.da2;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.alainperez.da2.dialog.ExitDialog;
import com.alainperez.da2.graphic.SquareRenderer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GLSurfaceView view  =   (GLSurfaceView) this.findViewById(R.id.main_surface);
        GLSurfaceView view  =   new GLSurfaceView(this);
        view.setRenderer(new SquareRenderer(true));
        setContentView(view);
        //setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        super.onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId	=	item.getItemId();
        switch (itemId) {
            case R.id.menu_exit:
                ExitDialog ed	=	new ExitDialog(this);
                ed.startDialog();
                return true;
        }
        return false;
    }
}
