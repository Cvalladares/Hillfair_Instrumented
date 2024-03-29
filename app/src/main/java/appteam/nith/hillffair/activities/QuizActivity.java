package appteam.nith.hillffair.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import appteam.nith.hillffair.R;
import appteam.nith.hillffair.application.SharedPref;
import nl.vu.cs.s2group.*;

public class QuizActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button enter_quiz,leaderboard,instructions_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref pref= new SharedPref(this);
        setTheme(pref.getThemeId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_home);

        final SharedPref sp=new SharedPref(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enter_quiz=(Button)findViewById(R.id.enter_quiz);
        instructions_button=(Button)findViewById(R.id.quiz_instructions_link);
        leaderboard=(Button)findViewById(R.id.leaderboard_link);
        enter_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sp.getInstructionsReadStatus()){
                    startActivity(new Intent(QuizActivity.this,QuizQuestionActivity.class));
                }else{
                    Toast.makeText(QuizActivity.this,"Read Quiz Instructions first",Toast.LENGTH_LONG).show();
                }
            }
        });

        instructions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,InformationActivity.class));
            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,LeaderBoardActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        PrefetchingLib.setCurrentActivity(this);
    }
}
