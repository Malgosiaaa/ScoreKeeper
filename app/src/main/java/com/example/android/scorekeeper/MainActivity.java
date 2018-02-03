package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String STATE_SCORETEAMA = "scoreTeamA";
    static final String STATE_FOULSQUANTITYTEAMA = "foulsquantityTeamA";
    static final String STATE_SCORETEAMB = "scoreTeamB";
    static final String STATE_FOULSQUANTITYTEAMB = "foulsquantityTeamB";

    int scoreTeamA = 0;
    int foulsquantityTeamA = 0;
    int scoreTeamB = 0;
    int foulsquantityTeamB = 0;

    EditText teamA;
    EditText teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialization of edit text with teams names
        teamA = findViewById(R.id.name_teamA);
        teamB = findViewById(R.id.name_teamB);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the users current score and fouls state
        savedInstanceState.putInt(STATE_SCORETEAMA, scoreTeamA);
        savedInstanceState.putInt(STATE_FOULSQUANTITYTEAMA, foulsquantityTeamA);
        savedInstanceState.putInt(STATE_SCORETEAMB, scoreTeamB);
        savedInstanceState.putInt(STATE_FOULSQUANTITYTEAMB, scoreTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state of score and fouls from saved instance
        scoreTeamA = savedInstanceState.getInt(STATE_SCORETEAMA);
        foulsquantityTeamA = savedInstanceState.getInt(STATE_FOULSQUANTITYTEAMA);
        scoreTeamB = savedInstanceState.getInt(STATE_SCORETEAMB);
        foulsquantityTeamB = savedInstanceState.getInt(STATE_FOULSQUANTITYTEAMB);

        displayForTeamA(scoreTeamA);
        displayFoulsForTeamA(foulsquantityTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsForTeamB(foulsquantityTeamB);

    }

    // Increase the score for Team A by 1 point.
    public void addPointForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);

        Toast.makeText(this, R.string.goal, Toast.LENGTH_SHORT).show();
    }

    // Increase the foul quantity for Team A by 1.
    public void addFoulForTeamA(View v) {
        foulsquantityTeamA += 1;
        displayFoulsForTeamA(foulsquantityTeamA);

        Toast.makeText(this, R.string.foul_message, Toast.LENGTH_SHORT).show();
    }

    // Increase the score for Team B by 1 point.
    public void addPointForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);

        Toast.makeText(this, R.string.goal, Toast.LENGTH_SHORT).show();
    }

    // Increase the foul quantity for Team B by 1.
    public void addFoulForTeamB(View v) {
        foulsquantityTeamB += 1;
        displayFoulsForTeamB(foulsquantityTeamB);

        Toast.makeText(this, R.string.foul_message, Toast.LENGTH_SHORT).show();
    }

    //Displays the toast message with information about the winner and gained points
    public void endGame(View v) {
        String TeamAName = teamA.getText().toString();
        String TeamBName = teamB.getText().toString();

        if (scoreTeamA > scoreTeamB) {
            Toast.makeText(this, getString(R.string.congratulations) + TeamAName + getString(R.string.exclamation)
                    + "\n" + getString(R.string.you_won) + scoreTeamA + getString(R.string.points_message), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA < scoreTeamB) {
            Toast.makeText(this, getString(R.string.congratulations) + TeamBName + getString(R.string.exclamation) +
                    "\n" + getString(R.string.you_won) + scoreTeamB + getString(R.string.points_message), Toast.LENGTH_LONG).show();
        } else if (scoreTeamA == scoreTeamB) {
            Toast.makeText(this, getString(R.string.congratulations) + TeamAName + getString(R.string.and_message) + TeamBName + getString(R.string.exclamation) +
                    "\n" + getString(R.string.drew) + scoreTeamA + getString(R.string.points_message), Toast.LENGTH_LONG).show();
        }
    }

    // Resets score and fouls quantity for both teams
    public void reset(View v) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        foulsquantityTeamA = 0;
        displayFoulsForTeamA(foulsquantityTeamA);
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
        foulsquantityTeamB = 0;
        displayFoulsForTeamB(foulsquantityTeamB);
    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_teamA);
        scoreView.setText(String.valueOf(score));
    }

    // Displays the given fouls quantity for Team A.
    public void displayFoulsForTeamA(int foulsquantityTeamA) {
        TextView foulsView = (TextView) findViewById(R.id.fouls_teamA);
        foulsView.setText(String.valueOf(foulsquantityTeamA));
    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_teamB);
        scoreView.setText(String.valueOf(score));
    }

    // Displays the given fouls quantity for Team B.
    public void displayFoulsForTeamB(int foulsquantityTeamB) {
        TextView foulsView = (TextView) findViewById(R.id.fouls_teamB);
        foulsView.setText(String.valueOf(foulsquantityTeamB));
    }
}
