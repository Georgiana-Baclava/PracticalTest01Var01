package ro.pub.cs.systems.eim.practicaltest01var01.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private Button nordButton, sudButton, estButton, vestButton, sec_activity;
    private TextView textView;

    private Integer nrCardinals = 0;

    private ButtonOnClickListener buttonOnClickListener = new ButtonOnClickListener();

    private class ButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String text;
            String existent;

            switch (view.getId()) {
                case R.id.nord :
                    text = nordButton.getText().toString();
                    existent = textView.getText().toString();
                    textView.setText(existent + text + " ");
                    nrCardinals++;
                    break;
                case R.id.sud :
                    text = sudButton.getText().toString();
                    existent = textView.getText().toString();
                    textView.setText(existent + text + " ");
                    nrCardinals++;
                    break;
                case R.id.est :
                    text = estButton.getText().toString();
                    existent = textView.getText().toString();
                    textView.setText(existent + text + " ");
                    nrCardinals++;
                    break;
                case R.id.vest :
                    text = vestButton.getText().toString();
                    existent = textView.getText().toString();
                    textView.setText(existent + text + " ");
                    nrCardinals++;
                    break;
                case R.id.second_activity:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    String label = textView.getText().toString();
                    intent.putExtra("label", label);

                    textView.setText("");
                    nrCardinals = 0;

                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        textView = (TextView) findViewById(R.id.textView);

        nordButton = (Button) findViewById(R.id.nord);
        nordButton.setOnClickListener(buttonOnClickListener);
        sudButton = (Button) findViewById(R.id.sud);
        sudButton.setOnClickListener(buttonOnClickListener);
        estButton = (Button) findViewById(R.id.est);
        estButton.setOnClickListener(buttonOnClickListener);
        vestButton = (Button) findViewById(R.id.vest);
        vestButton.setOnClickListener(buttonOnClickListener);

        sec_activity = (Button) findViewById(R.id.second_activity);
        sec_activity.setOnClickListener(buttonOnClickListener);



        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("nrCardinals")) {
                Log.d("[Message]", savedInstanceState.getString("nrCardinals"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("nrCardinals", String.valueOf(nrCardinals));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("nrCardinals")) {
            Log.d("[Message]", savedInstanceState.getString("nrCardinals"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + intent.getStringExtra("button"), Toast.LENGTH_LONG).show();
        }
    }
}
