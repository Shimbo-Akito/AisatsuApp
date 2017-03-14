package jp.techacademy.akito.shimbo.aisatsuapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button01);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button01) {
            showTimePickerDialog();

        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog (this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView text = (TextView) findViewById(R.id.textview01);
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            text.setText("おはよう");
                        } else if(hourOfDay >= 10 && hourOfDay < 18) {
                            text.setText("こんにちは");
                        }else if (hourOfDay < 2 || hourOfDay >= 18){
                            text.setText("こんばんは");
                        }
                    }
                },
                13,
                0,
        true);
        timePickerDialog.show();
    }
}

