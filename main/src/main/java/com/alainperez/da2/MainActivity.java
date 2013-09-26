package com.alainperez.da2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.alainperez.da2.dialog.ExitDialog;
import com.alainperez.da2.graphic.SquareRenderer;

public class MainActivity extends Activity {

    private GLSurfaceView mGLView;
    private GLSurfaceView mSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();

        setContentView(mGLView);
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

    //Tutorial http://www.jayway.com/2013/05/09/opengl-es-2-0-tutorial-for-android-part-i-getting-started/
    private void initialize(){
        mGLView = new GLSurfaceView(this);
        mGLView.setEGLContextClientVersion(2);
        mGLView.setPreserveEGLContextOnPause(true);
        mGLView.setRenderer(new MainRenderer());
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(mSurfaceView != null){
            mSurfaceView.onResume();
        }

    }

    @Override
    protected void onPause(){
        super.onPause();
        if(mSurfaceView != null){
            mSurfaceView.onPause();
        }
    }
}
