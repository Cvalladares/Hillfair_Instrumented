package appteam.nith.hillffair.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;

import appteam.nith.hillffair.R;
import nl.vu.cs.s2group.*;

public class SplashActivity extends AppCompatActivity {
    private static final long TIME_SPLASH =1500 ;
    private ImageView image_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PrefetchingLib.init(this, 3);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        image_splash = (ImageView) findViewById(R.id.image_spalsh);
        Target<GlideDrawable> into = Glide.with(SplashActivity.this).load(R.drawable.splash_new2).into(image_splash);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
                  finish();
            }
        },TIME_SPLASH);

    }

    @Override
    protected void onResume() {
        super.onResume();
        PrefetchingLib.setCurrentActivity(this);
    }
}

