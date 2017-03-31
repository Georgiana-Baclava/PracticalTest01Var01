package ro.pub.cs.systems.eim.practicaltest01var01.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    private TextView labelTextView;
    private Button registerButton, cancelButton;

    private SecondActivityButtonOnClickListener secondaryActivityButtonOnClickListener = new SecondActivityButtonOnClickListener();

    private class SecondActivityButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();

            switch (view.getId()) {
                case R.id.register :
                    intent.putExtra("button", registerButton.getText().toString());
                    setResult(RESULT_OK, intent);
                    break;
                case R.id.cancel :
                    intent.putExtra("button", cancelButton.getText().toString());
                    setResult(RESULT_CANCELED, intent);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);


        labelTextView = (TextView) findViewById(R.id.label);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("label")) {
            String label = intent.getStringExtra("label");
            labelTextView.setText(label);
        }

        registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(secondaryActivityButtonOnClickListener);

        cancelButton = (Button) findViewById(R.id.cancel);
        cancelButton.setOnClickListener(secondaryActivityButtonOnClickListener);
    }
}
