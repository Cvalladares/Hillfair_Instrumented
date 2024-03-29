package appteam.nith.hillffair.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import appteam.nith.hillffair.R;
import appteam.nith.hillffair.application.SharedPref;
import nl.vu.cs.s2group.*;

public class InformationActivity extends AppCompatActivity {

    private Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);
        setTheme(pref.getThemeId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        accept=(Button)findViewById(R.id.accept_and_enter_quiz);

        final SharedPref sp=new SharedPref(this);

        if(sp.getInstructionsReadStatus()){
           accept.setVisibility(View.GONE);
        }

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.setInstructionsReadStatus(true);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        PrefetchingLib.setCurrentActivity(this);
    }
}
