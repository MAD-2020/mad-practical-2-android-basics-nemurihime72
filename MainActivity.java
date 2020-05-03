package sg.edu.np.WhackAMole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonLeft;
    private Button buttonMiddle;
    private Button buttonRight;
    private TextView Score;
    private static final String TAG = "Whack-A-Mole";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");
        buttonLeft = (Button) findViewById(R.id.Button1);   //sets name for button1 
        buttonMiddle = (Button) findViewById(R.id.Button2); //sets name for button2 
        buttonRight = (Button) findViewById(R.id.Button3);  //sets name for button3
        Score = (TextView) findViewById(R.id.Score);        //sets name for score

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Log.v(TAG, "Button Left clicked!");
                if (buttonLeft.getText() == "*")            //if correct button is pressed
                {
                    Log.v(TAG, "Hit, score added!");
                    Log.v(TAG, Score.getText().toString()); //for checking
                    addScore();                             //add 1 to score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
                else {                                      // if wrong button is pressed
                    Log.v(TAG, "Missed, score deducted!");
                    Log.v(TAG, Score.getText().toString()); //for checking
                    removeScore();                          //remove 1 from score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
            }
        });

        buttonMiddle.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v){
                Log.v(TAG, "Button Middle clicked");
                if (buttonMiddle.getText() == "*")          //if correct button is pressed
                {
                    Log.v(TAG, "Hit, score added!");
                    Log.v(TAG, Score.getText().toString()); //for checking
                    addScore();                             //add 1 to score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
                else {                                      // if wrong button is pressed
                    Log.v(TAG, "Missed, score deducted!");
                    Log.v(TAG, Score.getText().toString()); //for checking
                    removeScore();                          //remove 1 from score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
            }
        }));

        buttonRight.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v){
                Log.v(TAG, "Button Right clicked");
                if (buttonRight.getText() == "*")
                {
                    Log.v(TAG, "Hit, score added!");   //if correct button is pressed
                    Log.v(TAG, Score.getText().toString()); //for checking     
                    addScore();                             //add 1 to score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
                else {                                      // if wrong button is pressed
                    Log.v(TAG, "Missed, score deducted!");
                    Log.v(TAG, Score.getText().toString()); //for checking
                    removeScore();                          //remove 1 from score
                    Log.v(TAG, Score.getText().toString());
                    setNewMole();
                }
            }
        }));
    }
    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "Resuming...");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Pausing...");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopping!");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroying!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if (randomLocation == 0){       //sets which button is mole based on random result
            buttonLeft.setText("*");
            buttonMiddle.setText("O");
            buttonRight.setText("O");
        }
        else if (randomLocation==1){    //sets which button is mole based on random result
            buttonLeft.setText("O");
            buttonMiddle.setText("*");
            buttonRight.setText("O");
        }
        else {                          //sets which button is mole based on random result
            buttonLeft.setText("O");
            buttonMiddle.setText("O");
            buttonRight.setText("*");
        }
    }
    public void addScore()
    {
        int intScore = Integer.parseInt(Score.getText().toString());    //gets int score from the textview after getting text and converting to string
        intScore += 1;  //adds 1 to score
        String score = Integer.toString(intScore);  //convert back to string
        Score.setText(score);   //sets the printed textview to the new score
    }

    public void removeScore()
    {
        int intScore = Integer.parseInt(Score.getText().toString());    //gets int score from the textview after getting text and converting to string
        if (intScore != 0 ){    //if score is not 0
            intScore-=1;        // score - 1
        }
        else {                  //if score is 0
            intScore=0;         //score will remain 0
        }
        String score = Integer.toString(intScore);  //convert back to string
        Score.setText(score);   //sets the printed textview to the new score
    }
}
