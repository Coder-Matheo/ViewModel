package rob.myappcompany.viewmodelarchitect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button addScoreButton;
    Button resetScoreButton;

    ScoreViewModel scoreViewModel;
    //int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        addScoreButton = findViewById(R.id.addScoreButton);
        resetScoreButton = findViewById(R.id.resetScoreButton);

        addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore();
            }
        });

        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        scoreViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                scoreTextView.setText(String.valueOf(integer));
            }
        });
        //scoreTextView.setText(String.valueOf(scoreViewModel.getScore()));

        //score = 0;
        //scoreTextView.setText(String.valueOf(score));
    }



    private void addScore() {
        scoreViewModel.addScore();
        //score += 1;
        //scoreTextView.setText(String.valueOf(score));

        scoreViewModel.addScore();
        scoreTextView.setText(String.valueOf(scoreViewModel.getScore()));
    }
    private void resetScore() {
        scoreViewModel.resetScore();

        //score = 0;
        //scoreTextView.setText(String.valueOf(score));

        //scoreViewModel.resetScore();
        //scoreTextView.setText(String.valueOf(scoreViewModel.getScore()));
    }
}