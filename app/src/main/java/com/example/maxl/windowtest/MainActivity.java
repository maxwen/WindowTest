package com.example.maxl.windowtest;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.graphics.PixelFormat;
import android.widget.ImageView;


public class MainActivity extends Activity {
    private WindowManager mWindowManager;

    private static final class GlobalActionsDialog extends Dialog implements DialogInterface {
        private final Context mContext;

        public GlobalActionsDialog(Context context) {
            super(context);
            mContext = context;
            setTitle("Title...");
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View v = getLayoutInflater().inflate(R.layout.dialog_layout, null);
            setContentView(v);

            final View iv = v.findViewById(R.id.imageView);
            final View iv1 = v.findViewById(R.id.imageView1);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv1.setSelected(false);
                    iv.setSelected(true);
                }
            });
            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv.setSelected(false);
                    iv1.setSelected(true);
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(v);
        mWindowManager = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        final View iv = v.findViewById(R.id.imageView);
        final View iv1 = v.findViewById(R.id.imageView1);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv1.setSelected(false);
                iv.setSelected(true);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setSelected(false);
                iv1.setSelected(true);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private WindowManager.LayoutParams getParams(int pixelFormat) {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                300,
                300,
                WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                        | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                pixelFormat);
        params.gravity = Gravity.CENTER;

        return params;
    }

    public void addWindow1(View v) {
        final FrameLayout mPopupView = new FrameLayout(this);
        mPopupView.setBackgroundColor(Color.RED);
        mPopupView.setElevation(50f);
        mPopupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.removeView(mPopupView);

            }
        });
        mWindowManager.addView(mPopupView, getParams(PixelFormat.TRANSLUCENT));
    }


    public void addWindow2(View v) {
        final FrameLayout mPopupView = new FrameLayout(this);
        mPopupView.setBackgroundColor(Color.YELLOW);
        mPopupView.setElevation(50f);
        mPopupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.removeView(mPopupView);

            }
        });
        mWindowManager.addView(mPopupView, getParams(PixelFormat.TRANSPARENT));
    }


    public void addWindow3(View v) {
        final FrameLayout mPopupView = new FrameLayout(this);
        mPopupView.setBackgroundColor(Color.BLUE);
        mPopupView.setElevation(50f);
        mPopupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.removeView(mPopupView);

            }
        });
        mWindowManager.addView(mPopupView, getParams(PixelFormat.OPAQUE));
    }
    public void openDialog(View v) {
        GlobalActionsDialog dialog = new GlobalActionsDialog(this);
        dialog.show();
    }
}
